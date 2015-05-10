
package edu.pm.uc.gantt.action;

import java.io.ObjectInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.gantt.bo.TargetModifyBO;
import edu.pm.uc.gantt.form.TargetUtil;
import edu.pm.vo.Targets;



public class TargetModifyAction extends PMBaseAction {

	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		response.setContentType("application/octest-stream");   
		
		ObjectInputStream   in=null;   
		Targets modifyTarget   =null;
        try{   
            in   =   new   ObjectInputStream(request.getInputStream());   
            modifyTarget   =   (Targets)   in.readObject();   
            in.close();
        }catch(Exception   e)   {   
            System.out.println("目前还没有对象"); 
            e.printStackTrace();
        } 
		
        TargetUtil util = new TargetUtil();
        
        // modify
        TargetModifyBO bo=new TargetModifyBO(modifyTarget);
		bo.execute();

		// update parents one by one util top level if the modified target is not top level
		Long tempTargetId=modifyTarget.getParentId();
		while(tempTargetId!=null){
			tempTargetId=util.adjustTarget(tempTargetId);
        }
		
		return null;

	}

}
