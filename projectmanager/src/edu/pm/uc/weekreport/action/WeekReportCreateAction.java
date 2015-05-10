/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.weekreport.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.constants.PMConstants;
import edu.pm.uc.problem.bo.ProblemCreateBO;
import edu.pm.uc.weekreport.bo.WeekReportCreateBO;
import edu.pm.uc.weekreport.form.WeekReportForm;
import edu.pm.vo.Problems;
import edu.pm.vo.WeekReports;

/**
 * This class provide the creating certificate battery basic information function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class WeekReportCreateAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		String projectId =(String) request.getSession().getAttribute("projectId");
		
		WeekReportForm aform = (WeekReportForm) form;
		
		WeekReports vo=aform.getVo();
		
		vo.setSubmitById(this.getUser().getId());
		
		vo.setSubmitDate(new Date());
		
		// new week report
		WeekReportCreateBO bo=new WeekReportCreateBO(vo);
		bo.execute();
		
		if(vo.getProblem()!=null && !vo.getProblem().equals("")){
			Problems problem = new Problems();
			problem.setSubmitById(this.getUser().getId());
			problem.setSubmitDate(new Date());
			problem.setProblemDescription(vo.getProblem());
			problem.setProjectId(new Long(projectId));
			problem.setStatus(PMConstants.StatusProblemtWait);
			// new problem
			ProblemCreateBO problemBO=new ProblemCreateBO(problem);
			problemBO.execute();
		}
		
		aform.reset(mapping,request);
		
		return mapping.findForward("success");

	}

}
