/*


 * Created on 2004-7-8


 *


 * TODO To change the template for this generated file go to


 * Window - Preferences - Java - Code Style - Code Templates


 */


package edu.dlmu.sei.struts.tag;





import javax.servlet.jsp.JspException;


import javax.servlet.jsp.tagext.TagSupport;





import org.apache.struts.util.RequestUtils;


import org.apache.struts.util.ResponseUtils;





import edu.dlmu.sei.util.PageRange;





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





public class IteratorNoTag extends TagSupport {





	/**


	 * The name of the scripting variable to be exposed as the current index.


	 */


	protected String indexId = null;





	protected String offset = null;





	protected int offsetValue;





	protected Object pageBean = null;





	protected PageRange pageinfo = null;





	public String getIndexId() {


		return (this.indexId);


	}





	public void setIndexId(String indexId) {


		this.indexId = indexId;


	}





	/**


	 * @return Returns the offset.


	 */


	public String getOffset() {


		return offset;


	}





	/**


	 * @param offset


	 *            The offset to set.


	 */


	public void setOffset(String offset) {


		this.offset = offset;


	}





	/**


	 * @return Returns the pageBean.


	 */


	public Object getPageBean() {


		return pageBean;


	}





	/**


	 * @param pageBean


	 *            The pageBean to set.


	 */


	public void setPageBean(Object pageBean) {


		this.pageBean = pageBean;


	}





	// --------------------------------------------------------- Public Methods





	/**


	 * Process the beginning of this tag.


	 * 


	 * @exception JspException


	 *                if a JSP exception has occurred


	 */


	public int doStartTag() throws JspException {





		//		Calculate the starting offset


		if (offset == null) {


			offsetValue = 1;


		} else {


			try {


				offsetValue = Integer.parseInt(offset);


			} catch (NumberFormatException e) {


				Integer offsetObject = (Integer) RequestUtils.lookup(


						pageContext, offset, null);


				if (offsetObject == null) {


					offsetValue = 0;


				} else {


					offsetValue = offsetObject.intValue();


				}


			}


		}


		if (offsetValue < 0) {


			offsetValue = 0;


		}





		// Calculate the page range object


		if (pageBean == null)


			pageBean = pageContext.getAttribute("pageinfo");





		if (pageBean != null) {


			if (pageBean instanceof PageRange) {


				pageinfo = (PageRange) pageBean;


			} else {


				pageinfo = null;


			}


		} else {


			pageinfo = null;


		}





		return (SKIP_BODY);





	}





	/**


	 * Render an input element for this tag.


	 * 


	 * @exception JspException


	 *                if a JSP exception has occurred


	 */


	public int doEndTag() throws JspException {





		int index = ((Integer) pageContext.getAttribute(indexId)).intValue()


				+ offsetValue;


		if (pageinfo != null) {


			int offset = pageinfo.getFirstResult();


			index += offset;


		}





		// Render this element to our response


		ResponseUtils.write(pageContext, index + "");





		// Continue evaluating this page


		return (EVAL_PAGE);





	}





	/**


	 * Release any acquired resources.


	 */


	public void release() {





		super.release();


		this.indexId = null;





	}





}