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
 * This class provide the creating certificate battery basic information function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class PayoutCreateBO extends PMBaseBusinessObject {

	private Payouts vo;
 
	Long id;
 
	private PMBaseDAO dao = new PMBaseDAO(Payouts.class);

	public Long getId() {
		return id;
	}

	public PayoutCreateBO(Payouts vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		id = (Long) dao.save(vo);

		
	}

}
