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
 * This class provide the deleting certificate battery affix function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class ProblemDeleteBO extends PMBaseBusinessObject {

	Long id;

	private PMBaseDAO dao = new PMBaseDAO(Problems.class);

	public Long getId() {
		return id;
	}

	public ProblemDeleteBO(Long id) {

		this.id = id;

	}

	protected void performBusinessLogic() {

		Problems po=(Problems)dao.loadAndLock(id);
		dao.delete(po);
	}

}
