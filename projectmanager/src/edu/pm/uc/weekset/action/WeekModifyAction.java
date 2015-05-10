/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.weekset.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.weekset.bo.WeekCheckBO;
import edu.pm.uc.weekset.bo.WeekModifyBO;
import edu.pm.uc.weekset.exception.WeekException;
import edu.pm.uc.weekset.form.WeekForm;
import edu.pm.vo.Weeks;


public class WeekModifyAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
		
			WeekForm aform = (WeekForm) form;
			Weeks vo=aform.getVo();
			
			try{
				//check
				WeekCheckBO checkBo =new WeekCheckBO(vo);
				checkBo.execute();
				//update
				WeekModifyBO bo=new WeekModifyBO(vo);
				bo.execute();
				
			}catch (WeekException e) {
				ActionMessages errors= new ActionMessages();
				errors.add("startDate", new ActionMessage("errors.week.exist"));
				saveErrors(request,errors);
				
				return mapping.getInputForward();
			}
				
			return mapping.findForward("success");

	}



}

