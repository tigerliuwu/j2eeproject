/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.risk.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.risk.bo.RiskModifyBO;
import edu.pm.uc.risk.form.RiskForm;
import edu.pm.vo.Risks;


public class RiskModifyAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
		
			RiskForm aform = (RiskForm) form;
			Risks vo=aform.getVo();
			
			//update
			RiskModifyBO bo=new RiskModifyBO(vo);
			bo.execute();
			
				
			return mapping.findForward("success");

	}



}

