
package edu.pm.uc.background.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.background.bo.ProjectDeleteBO;
import edu.pm.uc.teamset.bo.UserRoleDeleteBO;
import edu.pm.vo.Projects;
import edu.pm.vo.UserRole;



public class BackProjectDeleteAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String Id = request.getParameter("id");

		Long IdLong = new Long(Id);
		Projects project = (Projects)ConstantsContainer.getInstants().getVO(PMConstants.Projects,Id);
		
	
		// delete pm role
		PMBaseQuery userRoleQuery = new PMBaseQuery(UserRole.class);
		userRoleQuery.setEQ("projectId",IdLong);
		userRoleQuery.setEQ("userId",project.getPmId());
		userRoleQuery.setEQ("roleId",PMConstants.ROLE_PM);
		userRoleQuery.execute();
		UserRole userRole=(UserRole)userRoleQuery.getResults().get(0);
		
		UserRoleDeleteBO userRoleBO = new UserRoleDeleteBO(userRole.getId());
		userRoleBO.execute();
			
		ProjectDeleteBO bo = new ProjectDeleteBO(IdLong);
		bo.execute();
		
		return mapping.findForward("success");


	}

}
