package edu.pm.uc.background.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.projectinfor.bo.ProjectModifyBO;
import edu.pm.uc.projectinfor.form.ProjectForm;
import edu.pm.vo.Projects;

public class BackProjectModifyAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		
		ProjectForm aform = (ProjectForm) form;

		Projects vo=aform.getVo();
		
		ProjectModifyBO bo=new ProjectModifyBO(vo);
		
		bo.execute();
	
		return mapping.findForward("success");
		
	}

}
