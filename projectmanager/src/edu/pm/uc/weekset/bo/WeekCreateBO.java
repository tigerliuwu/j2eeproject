/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.weekset.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.Weeks;

/**
 * This class provide the creating certificate battery basic information function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class WeekCreateBO extends PMBaseBusinessObject {

	private Weeks vo;
 
	Long id;
 
	private PMBaseDAO dao = new PMBaseDAO(Weeks.class);

	public Long getId() {
		return id;
	}

	public WeekCreateBO(Weeks vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		id = (Long) dao.save(vo);

		
	}

}
