/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.payout.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.Payouts;

/**
 * This class provide the modifying certificate battery basic information function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class PayoutModifyBO extends PMBaseBusinessObject {

	private Payouts vo;


	private PMBaseDAO dao = new PMBaseDAO(Payouts.class);

	

	public PayoutModifyBO(Payouts vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		Payouts po=(Payouts)dao.loadAndLock(vo.getId());
		
		po.setStartDate(vo.getStartDate());
		po.setEndDate(vo.getEndDate());
		po.setPayPlan(vo.getPayPlan());
		po.setPayFact(vo.getPayFact());
		po.setRemark(vo.getRemark());
		
		dao.update(po);

	}

}
