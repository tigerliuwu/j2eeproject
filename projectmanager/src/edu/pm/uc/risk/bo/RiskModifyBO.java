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
 * This class provide the modifying certificate battery basic information function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class RiskModifyBO extends PMBaseBusinessObject {

	private Risks vo;


	private PMBaseDAO dao = new PMBaseDAO(Risks.class);

	

	public RiskModifyBO(Risks vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		Risks po=(Risks)dao.loadAndLock(vo.getId());
		
		po.setProjectId(vo.getProjectId());
		po.setSubmitById(vo.getSubmitById());
		po.setRiskDescription(vo.getRiskDescription());
		po.setRiskLevel(vo.getRiskLevel());
		po.setProbability(vo.getProbability());
		po.setSubmitDate(vo.getSubmitDate());
		po.setInfluence(vo.getInfluence());
		po.setKeepAwayMeasure(vo.getKeepAwayMeasure());
		po.setStatus(vo.getStatus());
		
		dao.update(po);

	}

}
