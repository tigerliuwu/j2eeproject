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
import edu.pm.uc.problem.bo.ProblemModifyBO;
import edu.pm.uc.problem.form.ProblemForm;
import edu.pm.vo.Problems;


public class ProblemModifyAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
		
			ProblemForm aform = (ProblemForm) form;
			Problems vo=aform.getVo();
			
			//update
			ProblemModifyBO bo=new ProblemModifyBO(vo);
			bo.execute();
			
				
			return mapping.findForward("success");

	}



}

