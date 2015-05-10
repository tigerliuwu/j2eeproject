/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.targetperson.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.targetperson.form.TargetForm;
import edu.pm.vo.Projects;
import edu.pm.vo.Targets;


public class TargetPersonModifyPreAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
		
			String isReEntry=request.getParameter("reEntry");
			if(isReEntry!=null){
				return mapping.findForward("success");
			}
			String projectId = (String)request.getSession().getAttribute("projectId");

			// 标题信息 ----------------------------------------------------------

			Projects project = (Projects) ConstantsContainer.getInstants().getVO(
					PMConstants.Projects, projectId);

			request.setAttribute("project", project);
			
			
			TargetForm aform = (TargetForm) form;
			
			String targetId = aform.getId();
			
			PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);
			
			Targets vo = (Targets)targetQuery.loadByID(Targets.class,new Long(targetId),false);

			aform.setVO(vo);
				
			return mapping.findForward("success");

	}



}

