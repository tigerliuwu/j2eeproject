
package edu.pm.uc.problem.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.Problems;

public class ProblemCreateBO extends PMBaseBusinessObject {

	private Problems vo;
 
	Long id;
 
	private PMBaseDAO dao = new PMBaseDAO(Problems.class);

	public Long getId() {
		return id;
	}

	public ProblemCreateBO(Problems vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		id = (Long) dao.save(vo);

		
	}

}
