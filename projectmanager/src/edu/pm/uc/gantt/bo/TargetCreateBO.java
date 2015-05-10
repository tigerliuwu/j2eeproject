
package edu.pm.uc.gantt.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.Targets;


public class TargetCreateBO extends PMBaseBusinessObject {

	private Targets vo;
 
	Long id;
 
	private PMBaseDAO dao = new PMBaseDAO(Targets.class);

	public Long getId() {
		return id;
	}

	public TargetCreateBO(Targets vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		id = (Long) dao.save(vo);

		
	}

}
