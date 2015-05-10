/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.login.bo.GetPermissionidBO;
import edu.pm.vo.Users;

public class ValidateAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
	  	String user_id=(String)request.getRemoteUser();
	  	
	  	if(user_id==null){
	  		
	  		return mapping.findForward("fail");
	  		
	  	}

		PMBaseQuery query = new PMBaseQuery(Users.class);

		query.setEQ("loginName",user_id);

		query.setEQ("isDeleted",PMConstants.DELETED_N);

		query.execute();

		Users user = (Users) query.getResults().get(0);

		HttpSession session = request.getSession();

		request.getSession(true).setAttribute("user", user);
		
		request.getSession(true).setAttribute("userName",user.getUserName());
		
		GetPermissionidBO bo=new GetPermissionidBO(user);
		
		bo.execute();
		
		session.setAttribute("permissionid",bo.getHs());
		
		return mapping.findForward("success");

	}

}
