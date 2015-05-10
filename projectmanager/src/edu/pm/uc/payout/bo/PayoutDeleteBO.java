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
 * This class provide the deleting certificate battery affix function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class PayoutDeleteBO extends PMBaseBusinessObject {

	Long id;

	private PMBaseDAO dao = new PMBaseDAO(Payouts.class);

	public Long getId() {
		return id;
	}

	public PayoutDeleteBO(Long id) {

		this.id = id;

	}

	protected void performBusinessLogic() {

		Payouts po=(Payouts)dao.loadAndLock(id);
		dao.delete(po);
	}

}
