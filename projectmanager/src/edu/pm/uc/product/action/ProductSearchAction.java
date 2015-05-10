package edu.pm.uc.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.constants.PMConstants;
import edu.pm.query.ProductQuery;
import edu.pm.uc.product.form.ProductCondition;
import edu.pm.uc.product.form.ProductSearchForm;
import edu.pm.vo.Products;
import edu.pm.vo.Projects;

public class ProductSearchAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String projectId =(String) request.getSession().getAttribute("projectId");
		
		ProductSearchForm sform = (ProductSearchForm) form;
		
		sform.initConditionPost();
		
		ProductCondition condition = (ProductCondition) sform.getCondition();

		ProductQuery productQuery = new ProductQuery(Products.class);
		
		productQuery.setLazy(true);
		
		productQuery.setEQ("targets.projectId",new Long(projectId));
		
		
		System.out.println(" condition.getReferById():"+ condition.getReferById());
		System.out.println("condition.getStatus():"+ condition.getStatus());
		
		if(!(condition.getReferById()==null || condition.getReferById().equals(""))){
			productQuery.setEQ("referById",new Long(condition.getReferById()));
		}
		
		if(!(condition.getStatus()==null || condition.getStatus().equals(""))){
			productQuery.setEQ("status",condition.getStatus());
		}

		productQuery.setPageRange(sform.getPageinfo());

		productQuery.setOrderBy("referDate","desc");
		
		productQuery.execute();
		
		request.setAttribute("result", productQuery.getResults());
		
		// project -----------------------------------------------------------------------
		
		Projects project = (Projects)ConstantsContainer.getInstants().getVO(PMConstants.Projects,projectId);;
		
		request.setAttribute("project", project);
		
		 
		return mapping.findForward("success");

	}

}
