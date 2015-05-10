/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.problem.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.problem.bo.ProblemDeleteBO;

public class ProblemDeleteAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		// 删除一个已汇总问题
		String Id = request.getParameter("id");

		if (Id != null) {

			Long IdLong = new Long(Id);

			ProblemDeleteBO bo = new ProblemDeleteBO(IdLong);

			bo.execute();
			
			return mapping.findForward("success");
		}

		// 删除若干个待汇总问题
		String waitWork = request.getParameter("waitWork");
		if (waitWork != null) {
			String[] waitWorks = request.getParameterValues("waitWork");
			for (int i = 0; i < waitWorks.length; i++) {

				ProblemDeleteBO bo = new ProblemDeleteBO(new Long(waitWorks[i]));

				bo.execute();
			}

		}

		return mapping.findForward("success");

	}

}
