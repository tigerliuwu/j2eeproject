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
import edu.pm.uc.payout.bo.PayoutModifyBO;
import edu.pm.uc.payout.form.PayoutForm;
import edu.pm.vo.Payouts;


public class PayoutModifyAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
		
			PayoutForm aform = (PayoutForm) form;
			Payouts vo=aform.getVo();
			
			//update
			PayoutModifyBO bo=new PayoutModifyBO(vo);
			bo.execute();
			
				
			return mapping.findForward("success");

	}



}

