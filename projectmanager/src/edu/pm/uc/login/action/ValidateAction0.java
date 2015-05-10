/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.login.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.login.bo.GetPermissionidBO;
import edu.pm.uc.login.form.LoginForm;
import edu.pm.vo.Users;

public class ValidateAction0 extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		//System.out.println("come ");
		
		int times = 0;

		ActionMessages errors = new ActionMessages();

		String agent = request.getHeader("User-Agent");

		if (agent == null || agent.indexOf("MSIE 6") == -1) {

			//System.out.println("not ie 6");
			
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionError("errors.login.ie6"));

			saveErrors(request, errors);

			return mapping.getInputForward();

		}

		LoginForm loginForm = (LoginForm) form;

		if (loginForm.getUsername().equals("")) {

			//System.out.println("user name is blank");
			
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionError("errors.login.username"));

			saveErrors(request, errors);

			loginForm.setUsername(null);

			loginForm.setPassword(null);

			loginForm.setRand(null);

			return mapping.getInputForward();

		}

		PMBaseQuery query = new PMBaseQuery(Users.class);

		query.setEQ("loginName",loginForm.getUsername());

		query.setEQ("isDeleted",PMConstants.DELETED_N);

		query.execute();

		if (query.getResults().size() == 0) {
			
			//System.out.println("not a user");

			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionError("errors.login.username"));

			saveErrors(request, errors);

			loginForm.setUsername(null);

			loginForm.setPassword(null);

			loginForm.setRand(null);

			return mapping.getInputForward();

		}

		Users user = (Users) query.getResults().get(0);

		/*if (user.getPassword() == null) {

			user.setPassword("");

			new ModifyUserBO(user).execute();

		}*/

		if (!user.getPassword().equals(loginForm.getPassword())) {

			//System.out.println("password not right");
			
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionError("errors.login.password"));

			saveErrors(request, errors);

			loginForm.setUsername(null);

			loginForm.setPassword(null);

			loginForm.setRand(null);

			return mapping.getInputForward();

		}

		HttpSession session = request.getSession();

		String code = (String) session.getAttribute("rand");

		/*if (!code.equals(loginForm.getRand())) {

			//System.out.println("number not right");
			
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionError("errors.login.checkcode"));

			saveErrors(request, errors);

			loginForm.setPassword(null);

			loginForm.setRand(null);

			return mapping.getInputForward();

		}*/

		request.getSession(true).setAttribute("user", user);
		request.getSession(true).setAttribute("userName",user.getUserName());
		
		GetPermissionidBO bo=new GetPermissionidBO(user);
		
		bo.execute();
		
		session.setAttribute("permissionid",bo.getHs());
		

		Locale locale = null;


		return mapping.findForward("success");

	}

}
