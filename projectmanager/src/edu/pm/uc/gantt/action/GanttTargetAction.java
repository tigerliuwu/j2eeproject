package edu.pm.uc.gantt.action;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.base.PMBaseAction;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Projects;
import edu.pm.vo.Targets;

public class GanttTargetAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		String projectId = (String)request.getSession().getAttribute("projectId");
		
		Projects project = (Projects)ConstantsContainer.getInstants().getVO(PMConstants.Projects,projectId);
		
		Targets targetProject =new Targets();
		
		targetProject.setId(null);
		
		targetProject.setTargetName(project.getProjectName());
		
		targetProject.setStartDatePlan(project.getStartDate());
		
		targetProject.setEndDatePlan(project.getCloseDate());
		
		targetProject.setTargetLevel(new Integer(0));
		
		targetProject.setTargetOrder("");
		
		targetProject.setProjectId(new Long(projectId));
		
		targetProject.setDraw(true);
		
		targetProject.setIsParent("1");
		
		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);
		
		targetQuery.setEQ("projectId",new Long(projectId));
		
		targetQuery.setOrderBy("targetOrder","asc");
		
		targetQuery.execute();
		
		HashMap bigTargetMap = new HashMap();
		
		List targetList = targetQuery.getResults();
		
		targetList.add(0,targetProject);
		
		//request.setAttribute("result", targetList);
		
		OutputStream out;
	    ObjectOutputStream objStream;
	    out = response.getOutputStream();
	    objStream = new ObjectOutputStream(out);
	    objStream.writeObject((Object)targetList);
		
		return null;
		
	}

}
