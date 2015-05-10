/**

 * 

 */

package edu.dlmu.sei.util;



import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;



/**

 * @author bobby.dou,jichun.guo

 * 

 */

public class PermissionTag extends TagSupport {



	protected String permissionId = null;



	protected String scope = null;



	/*

	 * (non-Javadoc)

	 * 

	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()

	 */

	public int doEndTag() throws JspException {



		return (EVAL_PAGE);



	}



	/*

	 * (non-Javadoc)

	 * 

	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()

	 */

	public int doStartTag() throws JspException {



		Set permissionIdSet = (Set) TagUtils.getInstance().lookup(pageContext,

				"permissionid", "session");



		//System.out.println("permissionIdSet--: " + permissionIdSet);

		//System.out.println("permissionId--: " + permissionId);



		if (permissionIdSet.contains(permissionId)) {



			//System.out.println("Contained success!!");



			return (EVAL_BODY_INCLUDE);

		} else {



			//System.out.println("Contained failed!!");



			return (SKIP_BODY);

		}

	}



	/**

	 * Release all allocated resources.

	 */

	public void release() {



		super.release();

		permissionId = null;

		scope = null;



	}



	/**

	 * @return the permissionId

	 */

	public String getPermissionId() {

		return permissionId;

	}



	/**

	 * @param permissionId

	 *            the permissionId to set

	 */

	public void setPermissionId(String permissionId) {

		this.permissionId = permissionId;
		
		String projectId="";
		
		if(permissionId.indexOf("_")==-1){
			
			try {
				
				projectId=(String)TagUtils.getInstance().lookup(pageContext,"projectId", "session");
				
			} catch (JspException e) {

				e.printStackTrace();
				
			}
			
			this.permissionId=permissionId+"_"+projectId;
			
		}
		

	}



	/**

	 * @return the scope

	 */

	public String getScope() {

		return scope;

	}



	/**

	 * @param scope

	 *            the scope to set

	 */

	public void setScope(String scope) {

		this.scope = scope;

	}



}

