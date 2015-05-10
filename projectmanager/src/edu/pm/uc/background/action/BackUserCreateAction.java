package edu.pm.uc.background.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.background.bo.UserCreateBO;
import edu.pm.uc.background.form.UserForm;
import edu.pm.vo.Users;

public class BackUserCreateAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		UserForm aform = (UserForm) form;
		Users vo=aform.getVo();
		// new
		UserCreateBO bo=new UserCreateBO(vo);
		bo.execute();
		
		aform.reset(mapping,request);
		
		return mapping.findForward("success");

	}

}
