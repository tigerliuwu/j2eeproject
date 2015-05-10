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
import edu.pm.uc.weekset.bo.WeekDeleteBO;



/**
 * This class provide the deleting certificate battery function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class WeekDeleteAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		
		String Id = request.getParameter("id");
		
		
		if(Id==null){
			return mapping.getInputForward();
		}
		
		Long IdLong = new Long(Id);
		
	    WeekDeleteBO bo = new WeekDeleteBO(IdLong);

		bo.execute();
		
		return mapping.findForward("success");

	}



}

