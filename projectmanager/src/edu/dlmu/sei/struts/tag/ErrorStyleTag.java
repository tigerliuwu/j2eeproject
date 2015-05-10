/*


 * Created on 2004-7-8


 *


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





public class ErrorStyleTag extends BodyTagSupport {





	// ----------------------------------------------------- Instance Variables





	/**


	 * The constant String value to be returned when this checkbox is selected


	 * and the form is submitted.


	 */


	protected String constant = null;





	protected String style;





	protected String property = null;





	protected String defaultStyle = "color:red";





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





		if (property == null || property.trim().length() == 0) {


			int pos = constant.indexOf("name=");





			if (pos == -1) {


				throw new JspException("must exise name from this input tag");


			}





			property = constant.substring(pos + 6, constant.indexOf("\"",


					pos + 6));


		}





		if (hasPropertyInErrors()) {





			// Create an appropriate "input" element based on our parameters


			StringBuffer results = new StringBuffer("");





			int pos = constant.indexOf("style=");


			if (pos == -1) {


				if (constant.indexOf("/>") > 0) {


					results.append(constant


							.substring(0, constant.indexOf("/>")));


					results.append(" style=\"");


					results.append(style);


					results.append("\"/>");


				} else {


					results


							.append(constant


									.substring(0, constant.indexOf(">")));


					results.append(" style=\"");


					results.append(style);


					results.append("\">");


				}


			} else {


				results.append(constant.substring(0, pos + 7));


				results.append(style);


				results.append(";");


				results.append(constant.substring(pos + 7));


			}





			// Render this element to our response


			ResponseUtils.write(pageContext, results.toString());





		} else {


			// Render this element to our response


			ResponseUtils.write(pageContext, constant);


		}





		this.style = null;


		this.property = null;


		// Continue evaluating this page


		return (EVAL_PAGE);





	}





	protected boolean hasPropertyInErrors() throws JspException {


		ActionMessages am = null;





		try {


			// Definitely know it should be an error so


			// use method to retrieve errors.


			am = RequestUtils.getActionErrors(pageContext, Globals.ERROR_KEY);


		} catch (JspException e) {


			RequestUtils.saveException(pageContext, e);


			throw e;


		}





		Iterator iterator = am.get(property);





		return (iterator.hasNext());





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