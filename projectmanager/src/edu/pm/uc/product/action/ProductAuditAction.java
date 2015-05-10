/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.product.action;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.product.bo.ProductAuditBO;
import edu.pm.uc.product.form.ProductForm;
import edu.pm.vo.Products;
import edu.pm.vo.Users;


public class ProductAuditAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
		
			ProductForm aform = (ProductForm) form;
			
			Products vo=aform.getVo();
			
			Users user = this.getUser();
			
			vo.setAuditById(user.getId());
			
			vo.setAuditDate(new Date());
			
			//audit
			ProductAuditBO bo=new ProductAuditBO(vo);
			
			bo.execute();
			
				
			return mapping.findForward("success");

	}



}

