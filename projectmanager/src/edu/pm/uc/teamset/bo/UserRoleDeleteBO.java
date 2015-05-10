package edu.pm.uc.teamset.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.UserRole;

public class UserRoleDeleteBO extends PMBaseBusinessObject {

	Long id;

	private PMBaseDAO dao = new PMBaseDAO(UserRole.class);

	public Long getId() {
		return id;
	}

	public UserRoleDeleteBO(Long id) {

		this.id = id;

	}

	protected void performBusinessLogic() {

		UserRole po=(UserRole)dao.loadAndLock(id);
		dao.delete(po);
	}

}
