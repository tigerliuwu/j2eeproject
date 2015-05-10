/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.problem.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.problem.bo.ProblemCreateBO;
import edu.pm.uc.problem.form.ProblemForm;
import edu.pm.vo.Problems;

/**
 * This class provide the creating certificate battery basic information function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class ProblemCreateAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		String projectId =(String) request.getSession().getAttribute("projectId");
		
		ProblemForm aform = (ProblemForm) form;
		
		Problems vo=aform.getVo();
		
		vo.setProjectId(new Long(projectId));
		
		vo.setSubmitById(this.getUser().getId());
		
		vo.setSubmitDate(new Date());
		
		// new
		ProblemCreateBO bo=new ProblemCreateBO(vo);
		
		bo.execute();
		
		aform.reset(mapping,request);
		
		return mapping.findForward("success");

	}

}
