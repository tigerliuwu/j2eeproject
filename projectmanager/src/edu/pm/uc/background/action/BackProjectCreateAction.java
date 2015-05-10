package edu.pm.uc.background.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.constants.PMConstants;
import edu.pm.uc.background.bo.ProjectCreateBO;
import edu.pm.uc.projectinfor.form.ProjectForm;
import edu.pm.uc.teamset.bo.UserRoleCreateBO;
import edu.pm.vo.Projects;
import edu.pm.vo.UserRole;

public class BackProjectCreateAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		ProjectForm aform = (ProjectForm) form;
		Projects vo=aform.getVo();
		// new
		ProjectCreateBO bo=new ProjectCreateBO(vo);
		bo.execute();
		vo.setId(bo.getId());
		// pm  role
		UserRole userRole = new UserRole();
        userRole.setProjectId(bo.getId());
        userRole.setUserId(vo.getPmId());
        userRole.setIsWorking(PMConstants.WORKING_Y);
        userRole.setRoleId(PMConstants.ROLE_PM);
        UserRoleCreateBO createBO =new UserRoleCreateBO(userRole);
        createBO.execute();
		
		aform.reset(mapping,request);
		
		return mapping.findForward("success");

	}

}
