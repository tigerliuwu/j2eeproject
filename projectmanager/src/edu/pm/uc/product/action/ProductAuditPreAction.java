/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.product.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.query.ProductQuery;
import edu.pm.uc.product.form.ProductForm;
import edu.pm.vo.Products;


public class ProductAuditPreAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
		
			String isReEntry=request.getParameter("reEntry");
			if(isReEntry!=null){
				return mapping.findForward("success");
			}
			
			ProductForm aform = (ProductForm) form;
			
			String id = aform.getId();
			
			ProductQuery productQuery = new ProductQuery(Products.class);
			
			Products vo = (Products)productQuery.loadByID(Products.class,new Long(id),true);

			aform.setVO(vo);
				
			return mapping.findForward("success");

	}



}

