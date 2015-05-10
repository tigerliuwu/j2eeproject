package edu.pm.uc.background.bo;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Users;

public class UserCreateBO extends PMBaseBusinessObject {

	private Users vo;
 
	Long id;
 
	private PMBaseDAO dao = new PMBaseDAO(Users.class);

	public Long getId() {
		return id;
	}

	public UserCreateBO(Users vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		id = (Long) dao.save(vo);
		
		vo.setId(id);

		// update cache
		ConstantsContainer.getInstants().setVO(PMConstants.Users,vo);

	}

}
