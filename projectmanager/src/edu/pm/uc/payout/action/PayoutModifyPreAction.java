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
import edu.pm.base.PMBaseQuery;
import edu.pm.uc.payout.form.PayoutForm;
import edu.pm.vo.Payouts;


public class PayoutModifyPreAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
		
			String isReEntry=request.getParameter("reEntry");
			if(isReEntry!=null){
				return mapping.findForward("success");
			}
			
			PayoutForm aform = (PayoutForm) form;
			
			String payoutId = aform.getId();
			
			PMBaseQuery payoutQuery = new PMBaseQuery(Payouts.class);
			
			Payouts vo = (Payouts)payoutQuery.loadByID(Payouts.class,new Long(payoutId),false);

			aform.setVO(vo);
				
			return mapping.findForward("success");

	}



}

