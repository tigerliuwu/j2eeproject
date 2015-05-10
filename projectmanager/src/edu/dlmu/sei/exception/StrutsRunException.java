/*

 * Created on 2005-1-27

 *

 * TODO To change the template for this generated file go to

 * Window - Preferences - Java - Code Style - Code Templates

 */

package edu.dlmu.sei.exception;

import org.apache.struts.action.ActionMessage;

/**
 * 
 * @author george.lv 2005/1/27
 * 
 * 
 * 
 * TODO To provide Module Exception to catch property and error
 * 
 */

public class StrutsRunException extends RunException {

	protected String property = null;

	protected ActionMessage error = null;

	/**
	 * 
	 * Construct an module exception with no replacement values.
	 * 
	 * 
	 * 
	 * @param key
	 *            Message key for this error message
	 * 
	 */

	public StrutsRunException(String key) {

		super(key);

		error = new ActionMessage(key);

	}

	/**
	 * 
	 * Construct an module exception with the specified replacement values.
	 * 
	 * 
	 * 
	 * @param key
	 *            Message key for this error message
	 * 
	 * @param value
	 *            First replacement value
	 * 
	 */

	public StrutsRunException(String key, Object value) {

		super(key);

		error = new ActionMessage(key, value);

	}

	/**
	 * 
	 * Construct an module exception with the specified replacement values.
	 * 
	 * 
	 * 
	 * @param key
	 *            Message key for this error message
	 * 
	 * @param value0
	 *            First replacement value
	 * 
	 * @param value1
	 *            Second replacement value
	 * 
	 */

	public StrutsRunException(String key, Object value0, Object value1) {

		super(key);

		error = new ActionMessage(key, value0, value1);

	}

	/**
	 * 
	 * Construct an module exception with the specified replacement values.
	 * 
	 * 
	 * 
	 * @param key
	 *            Message key for this error message
	 * 
	 * @param value0
	 *            First replacement value
	 * 
	 * @param value1
	 *            Second replacement value
	 * 
	 * @param value2
	 *            Third replacement value
	 * 
	 */

	public StrutsRunException(String key, Object value0, Object value1,
			Object value2) {

		super(key);

		error = new ActionMessage(key, value0, value1, value2);

	}

	/**
	 * 
	 * Construct an module exception with the specified replacement values.
	 * 
	 * 
	 * 
	 * @param key
	 *            Message key for this error message
	 * 
	 * @param value0
	 *            First replacement value
	 * 
	 * @param value1
	 *            Second replacement value
	 * 
	 * @param value2
	 *            Third replacement value
	 * 
	 * @param value3
	 *            Fourth replacement value
	 * 
	 */

	public StrutsRunException(String key, Object value0, Object value1,
			Object value2, Object value3) {

		super(key);

		error = new ActionMessage(key, value0, value1, value2, value3);

	}

	/**
	 * 
	 * Construct an action error with the specified replacement values.
	 * 
	 * 
	 * 
	 * @param key
	 *            Message key for this message
	 * 
	 * @param values
	 *            Array of replacement values
	 * 
	 */

	public StrutsRunException(String key, Object[] values) {

		error = new ActionMessage(key, values);

	}

	/**
	 * 
	 * Returns the property associated with the exception.
	 * 
	 * @return Value of property.
	 * 
	 */

	public String getProperty() {

		return (property != null) ? property : error.getKey();

	}

	/**
	 * 
	 * Set the property associated with the exception.
	 * 
	 * It can be a name of the edit field, which 'caused' the exception.
	 * 
	 */

	public void setProperty(String property) {

		this.property = property;

	}

	/**
	 * 
	 * Returns the error associated with the exception.
	 * 
	 * @return Value of property error.
	 * 
	 */

	public ActionMessage getError() {

		return error;

	}

}
