/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.background.action;

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
import edu.pm.uc.login.form.LoginForm;
import edu.pm.vo.Users;

public class BackLoginAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		

		LoginForm loginForm = (LoginForm) form;

		PMBaseQuery query = new PMBaseQuery(Users.class);

		query.setEQ("loginName",loginForm.getUsername());
		
		query.setEQ("password",loginForm.getPassword());

		query.setEQ("isDeleted",PMConstants.DELETED_N);
		
		query.setEQ("isAdmin",PMConstants.ADMIN_Y);

		query.execute();

		if (query.getResults().size() == 0) {
			
			ActionMessages errors = new ActionMessages();

			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionError("errors.login.username"));

			saveErrors(request, errors);

			loginForm.setUsername(null);

			loginForm.setPassword(null);

			loginForm.setRand(null);

			return mapping.getInputForward();

		}

		Users user = (Users) query.getResults().get(0);
		
		HttpSession session = request.getSession();

		request.getSession(true).setAttribute("user", user);
		

		return mapping.findForward("success");

	}

}
