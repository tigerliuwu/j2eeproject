/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.risk.action;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.risk.form.RiskForm;
import edu.pm.vo.Projects;
import edu.pm.vo.Risks;


public class RiskModifyPreAction extends PMBaseAction {



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
			
			Map teamMap = project.getUserList();
			
			List teamList = new ArrayList();
			
			teamList.addAll(teamMap.values());
			
			Collections.sort(teamList);
			
			request.setAttribute("team", teamList);
			
			RiskForm aform = (RiskForm) form;
			
			String riskId = aform.getId();
			
			PMBaseQuery riskQuery = new PMBaseQuery(Risks.class);
			
			Risks vo = (Risks)riskQuery.loadByID(Risks.class,new Long(riskId),false);

			aform.setVO(vo);
				
			return mapping.findForward("success");

	}



}

