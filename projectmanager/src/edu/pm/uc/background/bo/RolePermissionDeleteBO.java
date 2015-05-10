package edu.pm.uc.background.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.RolePermission;

public class RolePermissionDeleteBO extends PMBaseBusinessObject {

	Long id;

	private PMBaseDAO dao = new PMBaseDAO(RolePermission.class);

	public Long getId() {
		return id;
	}

	public RolePermissionDeleteBO(Long id) {

		this.id = id;

	}

	protected void performBusinessLogic() {

		RolePermission po = (RolePermission) dao.loadAndLock(id);
		dao.delete(po);
		
		
	}

}
