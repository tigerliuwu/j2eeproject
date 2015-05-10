/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.weekset.action;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import edu.pm.base.PMBaseAction;
import edu.pm.uc.weekset.bo.WeekCheckBO;
import edu.pm.uc.weekset.bo.WeekCreateBO;
import edu.pm.uc.weekset.exception.WeekException;
import edu.pm.uc.weekset.form.WeekForm;
import edu.pm.vo.Weeks;


public class WeekDefaultAction extends PMBaseAction {



	protected ActionForward doWork(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response)

			throws Exception {

			//needTokenValid(request); 
		
		
			String projectIdStr =(String) request.getSession().getAttribute("projectId");
			
			
			WeekForm aform = (WeekForm) form;
			Weeks vo=aform.getVo();

			Long projectId = new Long(projectIdStr);
			
			///////////////////////////
			
			Integer workloadPerDay = vo.getWorkloadPerDay();
			
			Date startDate00 = vo.getStartDate();
			Date endDate00 = vo.getEndDate();
			
			// 将用户输入的开始时间，结束时间 推算到合法的时间段开始和结尾
			int whatDay=startDate00.getDay();
			switch(whatDay){
			case  6 :{startDate00.setTime(startDate00.getTime()+(long)1000*24*3600*2); break;}
			case  0 :{startDate00.setTime(startDate00.getTime()+(long)1000*24*3600); break;}
			}
			whatDay=endDate00.getDay();
			switch(whatDay){
			case  6 :{endDate00.setTime(startDate00.getTime()-(long)1000*24*3600); break;}
			case  0 :{endDate00.setTime(startDate00.getTime()-(long)1000*24*3600*2); break;}
			}
			if(startDate00.after(endDate00)){
				//throw new WeekException("开始时间和结束时间之间没有可用的缺省工作日");
				ActionMessages errors= new ActionMessages();
				errors.add("startDate", new ActionMessage("errors.week.exist"));
				saveErrors(request,errors);
				
				return mapping.getInputForward();
			}
			
			try{
				// 循环新建Weeks
				Date startDate =startDate00;
				Date endDate= new Date();
				endDate.setTime(startDate.getTime()+(long)1000*24*3600*(5-startDate.getDay()));
				while(endDate.before(endDate00)){
					Weeks week = new Weeks();
					week.setStartDate(startDate);
					week.setEndDate(endDate);
					week.setProjectId(projectId);
					week.setWorkloadPerDay(workloadPerDay);
					//check
					WeekCheckBO checkBo =new WeekCheckBO(week);
					checkBo.execute();
					//create
					WeekCreateBO bo=new WeekCreateBO(week);
					bo.execute();
					
					startDate.setTime(endDate.getTime()+(long)1000*24*3600*3);
					endDate.setTime(endDate.getTime()+(long)1000*24*3600*7);
				}
				//最后一个工作周
				Weeks week = new Weeks();
				week.setStartDate(startDate);
				week.setEndDate(endDate00);
				week.setProjectId(projectId);
				week.setWorkloadPerDay(workloadPerDay);
				// check
				WeekCheckBO checkBo =new WeekCheckBO(week);
				checkBo.execute();
				// create
				WeekCreateBO bo=new WeekCreateBO(week);
				bo.execute();
			}catch(WeekException e){
				ActionMessages errors= new ActionMessages();
				errors.add("startDate", new ActionMessage("errors.week.exist"));
				saveErrors(request,errors);
				
				return mapping.getInputForward();
			}
			
				
			return mapping.findForward("success");

	}



}

