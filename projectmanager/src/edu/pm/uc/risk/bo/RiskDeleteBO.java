/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */

package edu.pm.uc.risk.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.Risks;

/**
 * This class provide the deleting certificate battery affix function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class RiskDeleteBO extends PMBaseBusinessObject {

	Long id;

	private PMBaseDAO dao = new PMBaseDAO(Risks.class);

	public Long getId() {
		return id;
	}

	public RiskDeleteBO(Long id) {

		this.id = id;

	}

	protected void performBusinessLogic() {

		Risks po=(Risks)dao.loadAndLock(id);
		dao.delete(po);
	}

}
