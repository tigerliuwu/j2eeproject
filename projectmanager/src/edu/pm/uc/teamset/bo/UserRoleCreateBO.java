
package edu.pm.uc.teamset.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.UserRole;

public class UserRoleCreateBO extends PMBaseBusinessObject {

	private UserRole vo;
 
	Long id;
 
	private PMBaseDAO dao = new PMBaseDAO(UserRole.class);

	public Long getId() {
		return id;
	}

	public UserRoleCreateBO(UserRole vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		id = (Long) dao.save(vo);

		
	}

}
