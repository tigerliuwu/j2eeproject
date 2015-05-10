
package edu.pm.uc.gantt.action;

import java.io.ObjectInputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.gantt.bo.TargetDeleteBO;
import edu.pm.uc.gantt.form.TargetUtil;
import edu.pm.vo.Targets;



public class TargetDeleteAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		response.setContentType("application/octest-stream");   
		
		ObjectInputStream   in=null;   
		Targets deleteTarget   =null;
        try{   
            in   =   new   ObjectInputStream(request.getInputStream());   
            deleteTarget   =   (Targets)   in.readObject();   
            in.close();
        }catch(Exception   e)   {   
            System.out.println("目前还没有对象"); 
            e.printStackTrace();
        } 
        
        TargetUtil util = new TargetUtil();
        
        // delete all it's children and itself
        List targetList= util.getAllChildAndItTargets(deleteTarget);
        for (int i = 0; i < targetList.size(); i++) {
			Targets target = (Targets) targetList.get(i);
			TargetDeleteBO bo=new TargetDeleteBO(target.getId());
			bo.execute();

		}
        
		// update parents one by one util top level if the deleted target is not top level
		Long tempTargetId=deleteTarget.getParentId();
		
		while(tempTargetId!=null){
			tempTargetId=util.adjustTarget(tempTargetId);
        }
		
		return null;

	}

}
