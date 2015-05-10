/*
 * Created on 2006-9-15
 *
 */
package edu.pm.uc.projectinfor.bo;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Projects;

public class ProjectModifyBO extends PMBaseBusinessObject {

	private Projects vo;


	private PMBaseDAO dao = new PMBaseDAO(Projects.class);

	

	public ProjectModifyBO(Projects vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		Projects po=(Projects)dao.loadAndLock(vo.getId());
		
		po.setPmId(vo.getPmId());
		
		po.setBudget(vo.getBudget());
		
		po.setPersonCost(vo.getPersonCost());
		
		po.setTeamSize(vo.getTeamSize());
		
		po.setCloseDate(vo.getCloseDate());
		
		po.setStartDate(vo.getStartDate());
		
		po.setProjectCode(vo.getProjectCode());
		po.setProjectName(vo.getProjectName());
		po.setProjectGoal(vo.getProjectGoal());
		po.setDevelopRoof(vo.getDevelopRoof());
		po.setDevelopLanguage(vo.getDevelopLanguage());
		po.setStatus(vo.getStatus());
		po.setIsDeleted(vo.getIsDeleted());

		dao.update(po);
		
		// ¸üÐÂcache
		ConstantsContainer.getInstants().setVO(PMConstants.Projects,po);
		

	}

}
