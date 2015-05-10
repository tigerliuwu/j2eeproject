package edu.pm.uc.background.bo;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Users;

public class UserDeleteBO extends PMBaseBusinessObject {

	Long id;

	private PMBaseDAO dao = new PMBaseDAO(Users.class);

	public Long getId() {
		return id;
	}

	public UserDeleteBO(Long id) {

		this.id = id;

	}

	protected void performBusinessLogic() {

		Users po = (Users) dao.loadAndLock(id);
		dao.delete(po);
		
		// update cache
		ConstantsContainer.getInstants().removeVO(PMConstants.Users,id.toString());
		
		
	}

}
