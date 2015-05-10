package edu.pm.uc.background.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.RolePermission;

public class RolePermissionCreateBO extends PMBaseBusinessObject {

	private RolePermission vo;
 
	Long id;
 
	private PMBaseDAO dao = new PMBaseDAO(RolePermission.class);

	public Long getId() {
		return id;
	}

	public RolePermissionCreateBO(RolePermission vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		id = (Long) dao.save(vo);
		
	}

}
