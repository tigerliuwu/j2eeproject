/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.problem.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.problem.bo.ProblemModifyBO;
import edu.pm.vo.Problems;


public class ProblemSumAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
		
			// 汇总若干个待汇总问题
			String waitWork = request.getParameter("waitWork");
			if (waitWork != null) {
				String[] waitWorks = request.getParameterValues("waitWork");
				PMBaseQuery problemQuery = new PMBaseQuery(Problems.class);
				for (int i = 0; i < waitWorks.length; i++) {
					Problems vo = (Problems)problemQuery.loadByID(Problems.class,new Long(waitWorks[i]),false);
					vo.setStatus(PMConstants.StatusProblemSum);
					//update
					ProblemModifyBO bo=new ProblemModifyBO(vo);
					bo.execute();
				}
	
			}
			
				
			return mapping.findForward("success");

	}



}

