/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.problem.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.Problems;

/**
 * This class provide the modifying certificate battery basic information function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class ProblemModifyBO extends PMBaseBusinessObject {

	private Problems vo;


	private PMBaseDAO dao = new PMBaseDAO(Problems.class);

	

	public ProblemModifyBO(Problems vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		Problems po=(Problems)dao.loadAndLock(vo.getId());
		
		po.setProjectId(vo.getProjectId());
		po.setSubmitById(vo.getSubmitById());
		po.setCloseDate(vo.getCloseDate());
		po.setSubmitDate(vo.getSubmitDate());
		po.setCorrectMeasure(vo.getCorrectMeasure());
		po.setStatus(vo.getStatus());
		po.setProblemLevel(vo.getProblemLevel());
		po.setValidateById(vo.getValidateById());
		po.setSolveById(vo.getSolveById());
		po.setProblemDescription(vo.getProblemDescription());
		
		dao.update(po);

	}

}
