/*
 * Created on 2006-9-15
 *
 */
package edu.pm.uc.background.bo;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Users;

public class UserModifyBO extends PMBaseBusinessObject {

	private Users vo;


	private PMBaseDAO dao = new PMBaseDAO(Users.class);

	

	public UserModifyBO(Users vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		Users po=(Users)dao.loadAndLock(vo.getId());
		
		po.setLoginName(vo.getLoginName());
		po.setAddress(vo.getAddress());
		po.setEmail(vo.getEmail());
		po.setHandset(vo.getHandset());
		po.setIsAdmin(vo.getIsAdmin());
		po.setIsDeleted(vo.getIsDeleted());
		po.setPassword(vo.getPassword());
		po.setPhone(vo.getPhone());
		po.setSex(vo.getSex());
		po.setUserName(vo.getUserName());

		dao.update(po);
		
		// ¸üÐÂcache
		ConstantsContainer.getInstants().setVO(PMConstants.Users,po);
		

	}

}
