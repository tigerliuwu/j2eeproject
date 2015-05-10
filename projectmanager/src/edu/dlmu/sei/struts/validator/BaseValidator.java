/*
 * Created on 2004-7-14
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */package edu.dlmu.sei.struts.validator;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.GenericTypeValidator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.ValidatorUtil;
import org.apache.regexp.RE;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.validator.FieldChecks;
import org.apache.struts.validator.Resources;
import edu.dlmu.sei.util.CoreUtils;

/**
 * * * * *
 * 
 * @author stony.feng * * * * * * * * TODO To change the template for this
 *         generated type comment go to Window - * * * * Preferences - Java -
 *         Code Style - Code Templates * * *
 */
public class BaseValidator {
	public void validateString(ActionErrors errors, int maxlength,
			String value, String property, String messages) {
		if (value == null || value.trim().equals("")) {
			errors.add(property, new ActionError("errors.required", messages));
		} else {
			if (value.length() > maxlength) {
				errors.add(property, new ActionError("errors.maxlength",
						messages, new Integer(maxlength)));
			}
		}
	}

	public void validateNumber(ActionErrors errors, BigDecimal min,
			BigDecimal max, String value, String property, String message) {
		if (!BaseValidator.isValidateString(value))
			return;
		if (!BaseValidator.isDouble(value)) {
			errors.add(property, new ActionError("errors.invalid", message
					+ ":" + value));
		} else {
			double dval = BaseValidator.toDouble(value);
			if (min != null) {
				if (dval < min.doubleValue()) {
					errors.add(property, new ActionError("errors.lessthan.min",
							message + ":" + value, min));
				}
			}
			if (max != null && max.doubleValue() > 0) {
				if (dval > max.doubleValue()) {
					errors
							.add(property, new ActionError(
									"errors.greatthan.max", message + ":"
											+ value, max));
				}
			}
		}
	}

	public static boolean isDate(String val) {
		boolean ret = true;
		Date dval = CoreUtils.parseDate(val);
		if (dval == null) {
			ret = false;
		}
		return ret;
	}

	public static boolean isDouble(String val) {
		boolean ret = true;
		Double dval = GenericTypeValidator.formatDouble(val);
		if (dval == null) {
			ret = false;
		}
		return ret;
	}

	public static double toDouble(String val) {
		Double dval = GenericTypeValidator.formatDouble(val);
		return dval.doubleValue();
	}

	public static boolean isInteger(String val) {
		boolean ret = true;
		Integer ival = GenericTypeValidator.formatInt(val);
		if (ival == null) {
			ret = false;
		}
		return ret;
	}

	public static boolean isLong(String val) {
		boolean ret = true;
		Long lval = GenericTypeValidator.formatLong(val);
		if (lval == null) {
			ret = false;
		}
		return ret;
	}

	public static long toLong(String val) {
		Long lval = GenericTypeValidator.formatLong(val);
		return lval.longValue();
	}

	public static int toInt(String val) {
		Integer ival = GenericTypeValidator.formatInt(val);
		return ival.intValue();
	}

	public static boolean isValidateString(String str) {
		return !(str == null || str.trim().equals(""));
	}

	public static boolean validateMaxLength(Object bean, ValidatorAction va,
			Field field, ActionMessages errors, Validator validator,
			HttpServletRequest request) {
		String value = null;
		if (isString(bean)) {
			value = (String) bean;
		} else {
			value = ValidatorUtil.getValueAsString(bean, field.getProperty());
		}
		if (value != null) {
			try {
				int max = Integer.parseInt(field.getVarValue("belength"));
				if (!maxLength(value, max)) {
					errors.add(field.getKey(), Resources.getActionMessage(
							validator, request, va, field));
					return false;
				}
			} catch (Exception e) {
				errors.add(field.getKey(), Resources.getActionMessage(request,
						va, field));
				return false;
			}
		}
		return true;
	}

	protected static boolean isString(Object o) {
		return (o == null) ? true : String.class.isInstance(o);
	}

	public static boolean maxLength(String value, int max) {
		byte[] bs;
		try {
			bs = value.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			return false;
		}
		return (bs.length <= max);
	}

	public static boolean isCash(String value) {
		if (StringUtils.isBlank(value))
			return true;
		String regexp = "(^-?0(.[0-9]{1,2})?$)|(^-?[1-9][0-9]{0,15}(.[0-9]{1,2})?$)";
		RE re = new RE(regexp);
		return re.match(value);
	}

	public static boolean isPositive(String value) {
		if (StringUtils.isBlank(value))
			return true;
		String regexp = "(^[0-9]{0,2}$)";
		RE re = new RE(regexp);
		return re.match(value);
	}
}