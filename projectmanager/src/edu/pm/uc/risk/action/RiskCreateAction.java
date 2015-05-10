/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.risk.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.risk.bo.RiskCreateBO;
import edu.pm.uc.risk.form.RiskForm;
import edu.pm.vo.Risks;

/**
 * This class provide the creating certificate battery basic information function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class RiskCreateAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		String projectId =(String) request.getSession().getAttribute("projectId");
		
		RiskForm aform = (RiskForm) form;
		
		Risks vo=aform.getVo();
		
		vo.setProjectId(new Long(projectId));
		
		vo.setSubmitDate(new Date());
		
		// new
		RiskCreateBO bo=new RiskCreateBO(vo);
		
		bo.execute();
		
		aform.reset(mapping,request);
		
		return mapping.findForward("success");

	}

}
