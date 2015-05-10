
package edu.pm.uc.gantt.action;

import java.io.ObjectInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.constants.PMConstants;
import edu.pm.uc.gantt.bo.TargetCreateBO;
import edu.pm.uc.gantt.form.TargetUtil;
import edu.pm.vo.Targets;



public class TargetCreateAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		String projectId = (String)request.getSession().getAttribute("projectId");

		response.setContentType("application/octest-stream");   
		
		ObjectInputStream   in=null;   
		Targets newTarget   =null;
        try{   
            in   =   new   ObjectInputStream(request.getInputStream());   
            newTarget   =   (Targets)   in.readObject();   
            in.close();
        }catch(Exception   e)   {   
            System.out.println("目前还没有对象"); 
            e.printStackTrace();
        } 
		
        TargetUtil util = new TargetUtil();
        
    	Targets parentTarget = util.getTargetById(newTarget.getParentId());
        newTarget.setTargetOrder(util.newTargetOrder(newTarget.getParentId(),new Long(projectId)));
        newTarget.setTargetLevel(util.newTargetLevel(newTarget.getParentId()));
        newTarget.setProjectId(new Long(projectId));
		newTarget.setIsDeleted(PMConstants.DELETED_N);
		newTarget.setIsParent(PMConstants.PARENT_N);
		newTarget.setStatus(PMConstants.StatusTargetInit);
    
		// new 
        TargetCreateBO bo=new TargetCreateBO(newTarget);
		bo.execute();
		
		// update parents one by one util top level if the new target is not top level
		Long tempTargetId=newTarget.getParentId();
		while(tempTargetId!=null){
			tempTargetId=util.adjustTarget(tempTargetId);
        }
		
		return null;

	}

}
