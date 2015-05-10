/*



 * Created on 2004-7-8



 *



 * TODO To change the template for this generated file go to



 * Window - Preferences - Java - Code Style - Code Templates



 */



package edu.dlmu.sei.struts.tag;



import javax.servlet.jsp.JspException;



import javax.servlet.jsp.tagext.TagSupport;



import org.apache.struts.util.ResponseUtils;



/**

 * 

 * Tag for input fields of type "checkbox". This differs from CheckboxTag

 * 

 * because it assumes that the underlying property is an array getter (of any

 * 

 * supported primitive type, or String), and the checkbox is initialized to

 * 

 * "checked" if the value listed for the "value" attribute is present in the

 * 

 * values returned by the property getter.

 * 

 * 

 * 

 * @author Ralph Schaer

 * 

 * @author Craig R. McClanahan

 * 

 * @version $Revision: 1.18 $ $Date: 2002/12/16 03:41:43 $

 * 

 */



public class IteratorStyleTag extends TagSupport {



	/**

	 * 

	 * The name of the scripting variable to be exposed as the current index.

	 * 

	 */



	protected String istotal = null;



	protected String indexId = null;



	public String getIndexId() {



		return (this.indexId);



	}



	public void setIndexId(String indexId) {



		this.indexId = indexId;



	}



	protected String firstStyle;



	protected String secondStyle;



	protected String defaultFirstStyle = "bggray245";



	protected String defaultSecondStyle = "bggray230";



	// --------------------------------------------------------- Public Methods



	/**

	 * 

	 * Process the beginning of this tag.

	 * 

	 * 

	 * 

	 * @exception JspException

	 * 

	 * if a JSP exception has occurred

	 * 

	 */



	public int doStartTag() throws JspException {



		if (firstStyle == null)



			firstStyle = defaultFirstStyle;



		if (secondStyle == null)



			secondStyle = defaultSecondStyle;



		return (SKIP_BODY);



	}



	/**

	 * 

	 * Render an input element for this tag.

	 * 

	 * 

	 * 

	 * @exception JspException

	 * 

	 * if a JSP exception has occurred

	 * 

	 */



	public int doEndTag() throws JspException {



		int index = ((Integer) pageContext.getAttribute(indexId)).intValue();



		if (istotal != null)

			index++;



		String style = null;



		if (index % 2 == 1) {



			style = secondStyle;



		}

		else {



			style = firstStyle;



		}



		// Render this element to our response



		ResponseUtils.write(pageContext, style);



		this.firstStyle = null;



		this.secondStyle = null;



		// Continue evaluating this page



		return (EVAL_PAGE);



	}



	/**

	 * 

	 * Release any acquired resources.

	 * 

	 */



	public void release() {



		super.release();



		this.indexId = null;



		this.firstStyle = null;



		this.secondStyle = null;



	}



	/**

	 * 

	 * @return Returns the firstStyle.

	 * 

	 */



	public String getFirstStyle() {



		return firstStyle;



	}



	/**

	 * 

	 * @param firstStyle

	 * 

	 * The firstStyle to set.

	 * 

	 */



	public void setFirstStyle(String firstStyle) {



		this.firstStyle = firstStyle;



	}



	/**

	 * 

	 * @return Returns the secondStyle.

	 * 

	 */



	public String getSecondStyle() {



		return secondStyle;



	}



	/**

	 * 

	 * @param secondStyle

	 * 

	 * The secondStyle to set.

	 * 

	 */



	public void setSecondStyle(String secondStyle) {



		this.secondStyle = secondStyle;



	}



	public String getIstotal() {

		return istotal;

	}



	public void setIstotal(String istotal) {

		this.istotal = istotal;

	}



}