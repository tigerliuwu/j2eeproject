package edu.pm.uc.background.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.constants.PMConstants;
import edu.pm.uc.background.form.UserForm;
import edu.pm.vo.Users;

public class BackUserModifyPreAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String isReEntry=request.getParameter("reEntry");
		if(isReEntry!=null){
			return mapping.findForward("success");
		}
	
		UserForm aform = (UserForm) form;

		String userId = request.getParameter("id");	
		
		Users user = (Users)ConstantsContainer.getInstants().getVO(PMConstants.Users,userId);
		
		aform.setVO(user);
		
		return mapping.findForward("success");
		
	}

}
