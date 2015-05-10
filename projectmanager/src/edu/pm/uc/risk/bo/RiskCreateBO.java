
package edu.pm.uc.risk.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.Risks;

public class RiskCreateBO extends PMBaseBusinessObject {

	private Risks vo;
 
	Long id;
 
	private PMBaseDAO dao = new PMBaseDAO(Risks.class);

	public Long getId() {
		return id;
	}

	public RiskCreateBO(Risks vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		id = (Long) dao.save(vo);

		
	}

}
