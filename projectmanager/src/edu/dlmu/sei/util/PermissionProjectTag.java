/**

 * 

 */

package edu.dlmu.sei.util;



import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.taglib.TagUtils;



/**

 * @author bobby.dou

 * 

 */

public class PermissionProjectTag extends TagSupport {



	protected String permissionId = null;
	
	private String name = null;

	private String property = null;

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

		Set permissionIdProjectIdSet = (Set) TagUtils.getInstance().lookup(pageContext,"permissionid_projectid", "session");
		
		System.out.println("permissionIdProjectIdSet--: " + permissionIdProjectIdSet);

		Object projectIdLong = (Object) TagUtils.getInstance().lookup(pageContext,name, property,scope);

		String thisid=permissionId+"_"+projectIdLong;
		
		System.out.println("thisId--: " + thisid);

		if (permissionIdProjectIdSet.contains(thisid)) {

			System.out.println("Contained success!!");

			return (EVAL_BODY_INCLUDE);

		} else {

			System.out.println("Contained failed!!");

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



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getProperty() {
		return property;
	}



	public void setProperty(String property) {
		this.property = property;
	}



}

