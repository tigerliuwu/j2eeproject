package edu.pm.uc.workloadpic.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jfree.data.DefaultCategoryDataset;

import edu.dlmu.sei.util.ChartUtil;
import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.constants.PMConstants;
import edu.pm.uc.projectlist.bo.GetUserWorkloadBO;
import edu.pm.uc.projectlist.form.WeekWorkload;
import edu.pm.vo.Projects;
import edu.pm.vo.Users;

public class WorkloadPicAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		// ͼ������׼��-------------------------------------------------------
		String weekId = request.getParameter("weekId");
		Long weekIdLong = new Long(weekId);

		// project infor
		// ----------------------------------------------------------------------
		String projectId = (String) request.getSession().getAttribute("projectId");

		Projects project = (Projects) ConstantsContainer.getInstants().getVO(PMConstants.Projects, projectId);

		request.setAttribute("project", project);

		// team users
		// --------------------------------------------------------------------
		Map teamMap = project.getUserList();

		Map workMap = new HashMap();

		Iterator teamIt = teamMap.values().iterator();

		while (teamIt.hasNext()) {
			Users user = (Users) teamIt.next();
			GetUserWorkloadBO bo = new GetUserWorkloadBO(new Long(projectId),user.getId());
			bo.execute();
			List weekWorkloadList = bo.getWeekWorkloadList();
			Iterator weekWorkloadIt = weekWorkloadList.iterator();

			while (weekWorkloadIt.hasNext()) {
				WeekWorkload weekWorkload = (WeekWorkload) weekWorkloadIt.next();
				if (weekWorkload != null && weekWorkload.getWeekId().equals(weekIdLong)) {
					
					workMap.put(user.getId(), weekWorkload);
					break;
				}

			}// weekWorkloadIt

		}// teamIt

		// ���տ�ʼʱ������
		List resultList = new ArrayList();
		resultList.addAll(workMap.values());
		Collections.sort(resultList);

		// ͼ����������-------------------------------------------------------
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Iterator weekWorkloadIt = resultList.iterator();
		while (weekWorkloadIt.hasNext()) {
			WeekWorkload weekWorkload = (WeekWorkload) weekWorkloadIt.next();
			String userName=ConstantsContainer.getInstants().getLabel(PMConstants.Users,weekWorkload.getUserId().toString());
			dataset.addValue(weekWorkload.getWorkloadAssign(), "�ƻ�������",userName );
			dataset.addValue(weekWorkload.getWorkloadOver(), "ʵ�ʹ�����",userName );

		}

		String title = "��Ա������ͳ��";
		String xAxis = "��Ա";
		String yAxis = "����������λ����ʱ��";
		String filename = ChartUtil.createBar3DChart(title, xAxis, yAxis,dataset, request.getSession());

		request.setAttribute("filename", filename);
		
		request.setAttribute("result", resultList);

		return mapping.findForward("success");

	}

}
