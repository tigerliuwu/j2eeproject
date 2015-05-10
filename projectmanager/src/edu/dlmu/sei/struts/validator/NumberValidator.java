/*



 * Created on 2005-3-2



 *



 * TODO To change the template for this generated file go to



 * Window - Preferences - Java - Code Style - Code Templates



 */

package edu.dlmu.sei.struts.validator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericTypeValidator;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.ValidatorUtil;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.validator.Resources;

/**
 * 
 * 
 * 
 * @author george.lv
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * TODO To change the template for this generated type comment go to
 * 
 * 
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 * 
 * 
 * 
 */

public class NumberValidator extends BaseValidator {

	public static boolean validateNumber(Object bean, ValidatorAction va,

	Field field, ActionErrors errors, HttpServletRequest request) {

		String value = null;

		if (isString(bean)) {

			value = (String) bean;

		} else {

			value = ValidatorUtil.getValueAsString(bean, field.getProperty());

		}

		if (!GenericValidator.isBlankOrNull(value)) {

			try {

				Double.parseDouble(value);

				int index = value.indexOf(".");

				int intlength, declength;

				if (index == -1) {

					intlength = value.length();

					declength = 0;

				} else {

					intlength = index;

					declength = value.length() - index - 1;

				}

				int maxlength = Integer

				.parseInt(field.getVarValue("maxlength"));

				int decimalPrecision = Integer.parseInt(field

				.getVarValue("precision"));//

				if (intlength > maxlength - decimalPrecision ||

				declength > decimalPrecision) {

					errors.add(field.getKey(), Resources.getActionError(

					request, va, field));

					return false;

				}

			} catch (Exception e) {

				errors.add(field.getKey(), Resources.getActionError(request,

				va, field));

				return false;

			}

		}

		return true;

	}

	/**
	 * 
	 * 
	 * 
	 * Checks if the field can safely be converted to a double primitive.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param bean
	 * 
	 * The bean validation is being performed on.
	 * 
	 * 
	 * 
	 * @param va
	 * 
	 * The <code>ValidatorAction</code> that is currently being
	 * 
	 * performed.
	 * 
	 * 
	 * 
	 * @param field
	 * 
	 * The <code>Field</code> object associated with the current
	 * 
	 * 
	 * 
	 * field being validated.
	 * 
	 * 
	 * 
	 * @param errors
	 * 
	 * The <code>ActionErrors</code> object to add errors to if any
	 * 
	 * 
	 * 
	 * validation errors occur.
	 * 
	 * 
	 * 
	 * @param request
	 * 
	 * Current request object.
	 * 
	 * 
	 * 
	 * @return A Double if valid, a null otherwise.
	 * 
	 * 
	 * 
	 */

	public static Double validatePositiveDouble(Object bean,

	ValidatorAction va, Field field,

	ActionErrors errors,

	HttpServletRequest request) {

		Double result = null;

		String value = null;

		if (isString(bean)) {

			value = (String) bean;

		} else {

			value = ValidatorUtil.getValueAsString(bean, field.getProperty());

		}

		if (!GenericValidator.isBlankOrNull(value)) {

			result = GenericTypeValidator.formatDouble(value);

			if (result == null || result.doubleValue() <= 0) {

				errors.add(field.getKey(), Resources.getActionError(request,

				va, field));

			}

		}

		return result;

	}

}
