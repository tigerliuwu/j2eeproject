package edu.pm.uc.projectinfor.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.projectinfor.form.ProjectForm;
import edu.pm.vo.Projects;

public class ProjectInforPreAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String isReEntry=request.getParameter("reEntry");
		if(isReEntry!=null){
			return mapping.findForward("success");
		}
	
		ProjectForm aform = (ProjectForm) form;

		//先从request中获得projectId，如果得到将其放到session中，不能得到则从session中获得projectId	
		String projectId = request.getParameter("projectId");	
		if(projectId==null){
			projectId = (String)request.getSession().getAttribute("projectId");
		}
		else{	
			request.getSession().setAttribute("projectId",projectId);	
		}
		
		Projects project = (Projects)ConstantsContainer.getInstants().getVO(PMConstants.Projects,projectId);
		
		aform.setVO(project);
		
		return mapping.findForward("success");
		
	}

}
