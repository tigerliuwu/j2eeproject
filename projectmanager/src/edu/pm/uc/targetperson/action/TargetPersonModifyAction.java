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

import edu.pm.base.PMBaseAction;
import edu.pm.uc.gantt.bo.TargetModifyBO;
import edu.pm.uc.targetperson.form.TargetForm;
import edu.pm.vo.Targets;


public class TargetPersonModifyAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
		
			TargetForm aform = (TargetForm) form;
			Targets vo=aform.getVo();
			
			//update
			TargetModifyBO bo=new TargetModifyBO(vo);
			bo.execute();
			
				
			return mapping.findForward("success");

	}



}

