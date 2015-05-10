/*
 * Created on 2004-7-19 
 * Created By George.lv
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.dlmu.sei.struts.tag;

import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;

/**
 * Tag for input fields of type "checkbox". This differs from CheckboxTag
 * because it assumes that the underlying property is an array getter (of any
 * supported primitive type, or String), and the checkbox is initialized to
 * "checked" if the value listed for the "value" attribute is present in the
 * values returned by the property getter.
 * 
 * @author Ralph Schaer
 * @author Craig R. McClanahan
 * @version $Revision: 1.18 $ $Date: 2002/12/16 03:41:43 $
 */

public class ErrorsTag extends BodyTagSupport {

	// ----------------------------------------------------- Instance Variables

	/**
	 * The constant String value to be returned when this checkbox is selected
	 * and the form is submitted.
	 */
	protected String constant = null;

	protected String style;

	protected String property = null;

	protected String defaultStyle = "#FFFF00";

	/**
	 * @return Returns the property.
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * @param property
	 *            The property to set.
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * @return Returns the style.
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * @param style
	 *            The style to set.
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	// --------------------------------------------------------- Public Methods

	/**
	 * Process the beginning of this tag.
	 * 
	 * @exception JspException
	 *                if a JSP exception has occurred
	 */
	public int doStartTag() throws JspException {

		// Defer processing until the end of this tag is encountered
		this.constant = null;
		return (EVAL_BODY_BUFFERED);

	}

	/**
	 * Save the body contents of this tag as the constant that we will be
	 * returning.
	 * 
	 * @exception JspException
	 *                if a JSP exception has occurred
	 */
	public int doAfterBody() throws JspException {

		if (bodyContent != null)
			this.constant = bodyContent.getString().trim();
		if ("".equals(this.constant))
			this.constant = null;
		return (SKIP_BODY);

	}

	/**
	 * Render an input element for this tag.
	 * 
	 * @exception JspException
	 *                if a JSP exception has occurred
	 */
	public int doEndTag() throws JspException {

		if (style == null)
			style = defaultStyle;

		handlePropertyErrors();

		this.style = null;
		this.property = null;
		// Continue evaluating this page
		return (EVAL_PAGE);

	}

	private void handlePropertyErrors() throws JspException {
		ActionMessages am = null;
		StringBuffer results = new StringBuffer("");
		try {
			// Definitely know it should be an error so
			// use method to retrieve errors.
			am = RequestUtils.getActionMessages(pageContext, Globals.ERROR_KEY);
			Iterator it = am.properties();			
			results.append("<script>\n");
			results.append("var objects;\n");
			while (it.hasNext()) {
				String propertyName = (String) it.next();
				results.append("objects = document.getElementsByName('"
						+ propertyName + "');\n");
				results.append("if (objects != null && objects.length > 0){\n");
				results.append("	var object = objects[0];\n");
				results.append("	object.style.backgroundColor = \"" + style
						+ "\";\n");
				results.append("}\n");
			}
			results.append("</script>");
			ResponseUtils.write(pageContext, results.toString());
		} catch (JspException e) {
			RequestUtils.saveException(pageContext, e);
			throw e;
		}

	}

	/**
	 * Release any acquired resources.
	 */
	public void release() {

		super.release();
		constant = null;
		style = null;
		property = null;

	}

	public static void main(String[] args) {
		String constant = "<input type=\"text\" name=\"address\" value=\"1111\">";
		String style = "color:red";

		// Create an appropriate "input" element based on our parameters
		StringBuffer results = new StringBuffer("");

		int pos = constant.indexOf("style=");
		if (pos == -1) {
			results.append(constant.substring(0, constant.indexOf(">")));
			results.append(" style=\"");
			results.append(style);
			results.append("\">");
		} else {
			results.append(constant.substring(0, pos + 7));
			results.append(style);
			results.append(";");
			results.append(constant.substring(pos + 7));
		}

	}

}