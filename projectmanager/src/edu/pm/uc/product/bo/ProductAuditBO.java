/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.product.bo;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseDAO;
import edu.pm.vo.Products;

/**
 * This class provide the modifying certificate battery basic information function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class ProductAuditBO extends PMBaseBusinessObject {

	private Products vo;


	private PMBaseDAO dao = new PMBaseDAO(Products.class);

	

	public ProductAuditBO(Products vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		Products po=(Products)dao.loadAndLock(vo.getId());
		
		po.setAuditById(vo.getAuditById());
		po.setAuditDate(vo.getAuditDate());
		po.setStatus(vo.getStatus());
		po.setAuditRemark(vo.getAuditRemark());
		
		dao.update(po);

	}

}
