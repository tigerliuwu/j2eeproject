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

import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.uc.weekset.form.WeekForm;
import edu.pm.vo.Weeks;


public class WeekModifyPreAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
		
			String isReEntry=request.getParameter("reEntry");
			if(isReEntry!=null){
				return mapping.findForward("success");
			}
			
			WeekForm aform = (WeekForm) form;
			
			String weekId = aform.getId();
			
			PMBaseQuery weekQuery = new PMBaseQuery(Weeks.class);
			
			Weeks vo = (Weeks)weekQuery.loadByID(Weeks.class,new Long(weekId),false);

			aform.setVO(vo);
				
			return mapping.findForward("success");

	}



}

