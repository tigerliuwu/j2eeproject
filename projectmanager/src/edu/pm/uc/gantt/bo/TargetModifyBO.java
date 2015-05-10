/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.gantt.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.Targets;


public class TargetModifyBO extends PMBaseBusinessObject {

	private Targets vo;


	private PMBaseDAO dao = new PMBaseDAO(Targets.class);

	

	public TargetModifyBO(Targets vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		Targets po=(Targets)dao.loadAndLock(vo.getId());
		
		po.setProjectId(vo.getProjectId());
		po.setParentId(vo.getParentId());
		po.setUserPLId(vo.getUserPLId());
		po.setUserSEId(vo.getUserSEId());
		po.setWorkloadFact(vo.getWorkloadFact());
		po.setWorkloadPlan(vo.getWorkloadPlan());
		po.setStartDatePlan(vo.getStartDatePlan());
		po.setEndDatePlan(vo.getEndDatePlan());
		po.setStartDateFact(vo.getStartDateFact());
		po.setEndDateFact(vo.getEndDateFact());
		po.setRemark(vo.getRemark());
		po.setDisplayColor(vo.getDisplayColor());
		po.setExcuteStatus(vo.getExcuteStatus());
		po.setIsDeleted(vo.getIsDeleted());
		po.setIsParent(vo.getIsParent());
		po.setTargetLevel(vo.getTargetLevel());
		po.setStatus(vo.getStatus());
		po.setIsMilestone(vo.getIsMilestone());
		po.setTargetName(vo.getTargetName());
		po.setTargetOrder(vo.getTargetOrder());
		
		dao.update(po);

	}

}
