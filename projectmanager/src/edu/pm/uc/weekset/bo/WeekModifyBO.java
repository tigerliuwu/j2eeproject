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
 * This class provide the modifying certificate battery basic information function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class WeekModifyBO extends PMBaseBusinessObject {

	private Weeks vo;


	private PMBaseDAO dao = new PMBaseDAO(Weeks.class);

	

	public WeekModifyBO(Weeks vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		Weeks po=(Weeks)dao.loadAndLock(vo.getId());
		
		po.setProjectId(vo.getProjectId());
		po.setStartDate(vo.getStartDate());
		po.setEndDate(vo.getEndDate());
		po.setWorkloadPerDay(vo.getWorkloadPerDay());
		
		dao.update(po);

	}

}
