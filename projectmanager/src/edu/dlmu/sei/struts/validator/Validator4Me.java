package edu.dlmu.sei.struts.validator;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.Form;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.ValidatorResources;
import org.apache.commons.validator.ValidatorResult;
import org.apache.commons.validator.ValidatorResults;
import org.apache.commons.validator.util.ValidatorUtils;

/**
 * 
 * 
 * 
 * <p>
 * 
 * 
 * 
 * Validations are processed by the validate method. An instance of
 * 
 * <code>ValidatorResources</code>
 * 
 * 
 * 
 * is used to define the validators (validation methods) and the validation
 * 
 * 
 * 
 * rules for a JavaBean.
 * 
 * 
 * 
 * </p>
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @author David Winterfeldt
 * 
 * 
 * 
 * @author James Turner
 * 
 * 
 * 
 * @author David Graham
 * 
 * 
 * 
 * @version $Revision: 1.15 $ $Date: 2003/03/17 01:41:17 $
 * 
 * 
 * 
 */

public class Validator4Me extends Validator {

	/**
	 * 
	 * 
	 * 
	 * Construct a <code>Validator</code> that will use the
	 * 
	 * <code>ValidatorResources</code>
	 * 
	 * 
	 * 
	 * passed in to retrieve pluggable validators the different sets of
	 * 
	 * 
	 * 
	 * validation rules.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param resources
	 * 
	 * 
	 * 
	 * <code>ValidatorResources</code> to use during validation.
	 * 
	 * 
	 * 
	 */

	public Validator4Me(ValidatorResources resources) {

		super(resources);

	}

	/**
	 * 
	 * 
	 * 
	 * Construct a <code>Validator</code> that will use the
	 * 
	 * <code>ValidatorResources</code>
	 * 
	 * 
	 * 
	 * passed in to retrieve pluggable validators the different sets of
	 * 
	 * 
	 * 
	 * validation rules.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param resources
	 * 
	 * 
	 * 
	 * <code>ValidatorResources</code> to use during validation.
	 * 
	 * 
	 * 
	 * @param formName
	 * 
	 * 
	 * 
	 * Key used for retrieving the set of validation rules.
	 * 
	 * 
	 * 
	 */

	public Validator4Me(ValidatorResources resources, String formName) {

		super(resources, formName);

	}

	/**
	 * 
	 * 
	 * 
	 * Executes the given ValidatorAction and all ValidatorActions that it
	 * 
	 * 
	 * 
	 * depends on.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @return True if the validation succeeded.
	 * 
	 * 
	 * 
	 */

	private boolean validateFieldForRule(Field field, ValidatorAction va,

	ValidatorResults results, Map actions, int pos)

	throws ValidatorException {

		if (results.getValidatorResult(field.getKey()) != null) {

			ValidatorResult result = results.getValidatorResult(field.getKey());

			if (result.containsAction(va.getName())) {

				return result.isValid(va

				.getName());

			}

		}

		// Execute all validators that this validator depends on.

		if (va.getDepends() != null) {

			StringTokenizer st = new StringTokenizer(va.getDepends(), ",");

			while (st.hasMoreTokens()) {

				String depend = st.nextToken().trim();

				ValidatorAction action = (ValidatorAction) actions.get(depend);

				if (action == null) {

					// log.error("No ValidatorAction called " + depend

					// + " found for field " + field.getProperty());

					return false;

				}

				if (!validateFieldForRule(field, action, results, actions, pos)) {

					return false;

				}

			}

		}

		try {

			// Add these two Objects to the resources since they reference

			// the current validator action and field

			hResources.put(VALIDATOR_ACTION_KEY, va);

			hResources.put(FIELD_KEY, field);

			Class c = getClassLoader().loadClass(va.getClassname());

			List lParams = va.getMethodParamsList();

			int size = lParams.size();

			int beanIndexPos = -1;

			int fieldIndexPos = -1;

			Class[] paramClass = new Class[size];

			Object[] paramValue = new Object[size];

			for (int x = 0; x < size; x++) {

				String paramKey = (String) lParams.get(x);

				if (BEAN_KEY.equals(paramKey)) {

					beanIndexPos = x;

				}

				if (FIELD_KEY.equals(paramKey)) {

					fieldIndexPos = x;

				}

				// There were problems calling getClass on paramValue[]

				paramClass[x] = getClassLoader().loadClass(paramKey);

				paramValue[x] = hResources.get(paramKey);

			}

			Method m = c.getMethod(va.getMethod(), paramClass);

			// If the method is static we don't need an instance of the class

			// to call the method. If it isn't, we do.

			if (!Modifier.isStatic(m.getModifiers())) {

				try {

					if (va.getClassnameInstance() == null) {

						va.setClassnameInstance(c.newInstance());

					}

				} catch (Exception ex) {

					// log.error("Couldn't load instance " + "of class "

					// + va.getClassname() + ". " + ex.getMessage());

				}

			}

			Object result = null;

			if (field.isIndexed()) {

				Object oIndexed = PropertyUtils.getProperty(hResources

				.get(BEAN_KEY), field.getIndexedListProperty());

				Object indexedList[] = new Object[0];

				if (oIndexed instanceof Collection) {

					indexedList = ((Collection) oIndexed).toArray();

				} else if (oIndexed.getClass().isArray()) {

					indexedList = (Object[]) oIndexed;

				}

				// Set current iteration object to the parameter array

				paramValue[beanIndexPos] = indexedList[pos];

				// Set field clone with the key modified to represent

				// the current field

				Field indexedField = (Field) field.clone();

				indexedField.setKey(ValidatorUtils.replace(

				indexedField.getKey(), Field.TOKEN_INDEXED, "[" + pos

				+ "]"));

				paramValue[fieldIndexPos] = indexedField;

				result = m.invoke(va.getClassnameInstance(), paramValue);

				results.add(field, va.getName(), isValid(result), result);

				if (!isValid(result)) {

					return false;

				}

			} else {

				result = m.invoke(va.getClassnameInstance(), paramValue);

				results.add(field, va.getName(), isValid(result), result);

				if (!isValid(result)) {

					return false;

				}

			}

		} catch (Exception e) {

			// log.error("reflection: " + e.getMessage(), e);

			if (e instanceof NoSuchMethodException) {

				System.out.println("error property in:"

				+ va.getClassnameInstance().getClass());

			}

			results.add(field, va.getName(), false);

			if (e instanceof ValidatorException) {

				throw ((ValidatorException) e);

			}

			return false;

		}

		return true;

	}

	/**
	 * 
	 * 
	 * 
	 * Run the validations on a given field, modifying the passed
	 * 
	 * 
	 * 
	 * ValidatorResults to add in any new errors found. If the field is
	 * 
	 * 
	 * 
	 * indexed, run all the validations in the depends clause over each item in
	 * 
	 * 
	 * 
	 * turn, returning when the first one fails. If it's non-indexed, just run
	 * 
	 * 
	 * 
	 * it on the field.
	 * 
	 * 
	 * 
	 */

	private void validateField(Field field, ValidatorResults allResults)

	throws ValidatorException {

		Map actions = resources.getValidatorActions();

		if (field.isIndexed()) {

			Object oIndexed;

			try {

				oIndexed = PropertyUtils.getProperty(hResources.get(BEAN_KEY),

				field.getIndexedListProperty());

			} catch (Exception e) {

				// log.error("in validateField", e);

				return;

			}

			Object indexedList[] = new Object[0];

			if (oIndexed instanceof Collection) {

				indexedList = ((Collection) oIndexed).toArray();

			} else if (oIndexed.getClass().isArray()) {

				indexedList = (Object[]) oIndexed;

			}

			for (int pos = 0; pos < indexedList.length; pos++) {

				ValidatorResults results = new ValidatorResults();

				StringTokenizer st = new StringTokenizer(field.getDepends(),

				",");

				while (st.hasMoreTokens()) {

					String depend = st.nextToken().trim();

					ValidatorAction action = (ValidatorAction) actions

					.get(depend);

					if (action == null) {

						// log.error("No ValidatorAction called " + depend

						// + " found for field " + field.getProperty());

						return;

					}

					boolean good = validateFieldForRule(field, action, results,

					actions, pos);

					allResults.merge(results);

					if (!good) {

						break;

					}

				}

			}

		} else {

			ValidatorResults results = new ValidatorResults();

			StringTokenizer st = new StringTokenizer(field.getDepends(), ",");

			while (st.hasMoreTokens()) {

				String depend = st.nextToken().trim();

				ValidatorAction action = (ValidatorAction) actions.get(depend);

				if (action == null) {

					// log.error("No ValidatorAction called " + depend

					// + " found for field " + field.getProperty());

					return;

				}

				boolean good = validateFieldForRule(field, action, results,

				actions, 0);

				allResults.merge(results);

				if (!good) {

					return;

				}

			}

		}

	}

	/**
	 * 
	 * 
	 * 
	 * Performs validations based on the configured resources.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @return The <code>Map</code> returned uses the property of the
	 * 
	 * <code>Field</code>
	 * 
	 * 
	 * 
	 * for the key and the value is the number of error the field had.
	 * 
	 * 
	 * 
	 */

	public ValidatorResults validate() throws ValidatorException {

		ValidatorResults results = new ValidatorResults();

		Locale locale = null;

		if (hResources.containsKey(LOCALE_KEY)) {

			locale = (Locale) hResources.get(LOCALE_KEY);

		}

		hResources.put(VALIDATOR_KEY, this);

		if (locale == null) {

			locale = Locale.getDefault();

		}

		if (resources == null) {

			throw new ValidatorException(

			"Resources not defined for Validator");

		}

		Form form = resources.get(locale, formName);

		if (form != null) {

			for (Iterator i = form.getFields().iterator(); i.hasNext();) {

				Field field = (Field) i.next();

				if ((field.getPage() <= page) && (field.getDepends() != null)) {

					validateField(field, results);

				}

			}

		}

		return results;

	}

	/**
	 * 
	 * 
	 * 
	 * Returns if the result if valid. If the result object is
	 * 
	 * <code>Boolean</code>,
	 * 
	 * 
	 * 
	 * then it will the value. If the result object isn't <code>Boolean</code>,
	 * 
	 * 
	 * 
	 * then it will return <code>false</code> if the result object is
	 * 
	 * <code>null</code>
	 * 
	 * 
	 * 
	 * and <code>true</code> if it isn't.
	 * 
	 * 
	 * 
	 */

	private boolean isValid(Object result) {

		boolean isValid = false;

		if (result instanceof Boolean) {

			Boolean valid = (Boolean) result;

			isValid = valid.booleanValue();

		} else {

			isValid = (result != null);

		}

		return isValid;

	}

}
