/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */

package edu.pm.uc.weekset.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.Weeks;

/**
 * This class provide the deleting certificate battery affix function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class WeekDeleteBO extends PMBaseBusinessObject {

	Long id;

	private PMBaseDAO dao = new PMBaseDAO(Weeks.class);

	public Long getId() {
		return id;
	}

	public WeekDeleteBO(Long id) {

		this.id = id;

	}

	protected void performBusinessLogic() {

		Weeks po=(Weeks)dao.loadAndLock(id);
		dao.delete(po);
	}

}
