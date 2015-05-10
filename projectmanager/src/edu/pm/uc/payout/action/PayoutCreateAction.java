/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.payout.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.payout.bo.PayoutCreateBO;
import edu.pm.uc.payout.form.PayoutForm;
import edu.pm.vo.Payouts;

/**
 * This class provide the creating certificate battery basic information function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class PayoutCreateAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		String projectId =(String) request.getSession().getAttribute("projectId");
		
		
		PayoutForm aform = (PayoutForm) form;
		Payouts vo=aform.getVo();
		vo.setProjectId(new Long(projectId));
		
		// new
		PayoutCreateBO bo=new PayoutCreateBO(vo);
		bo.execute();
			
		aform.reset(mapping,request);
		
		return mapping.findForward("success");

	}

}
