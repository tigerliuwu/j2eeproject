package edu.pm.uc.gantt.form;

import java.util.Date;
import java.util.List;

import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;
import edu.pm.uc.gantt.bo.TargetModifyBO;
import edu.pm.vo.Targets;

/**
 * @author guo
 * 
 */
public class TargetUtil {
	
	

	public Integer newTargetLevel(Long parenetTargetId) {
		if(parenetTargetId != null){
			Targets parentTarget = getTargetById(parenetTargetId);
			return new Integer(parentTarget.getTargetLevel().intValue()+1);
		}
		return new Integer(1);
	}
	
	public String newTargetOrder(Long parenetTargetId, Long projectId) {
		
		List targetList = null;
		if (parenetTargetId != null) {
			targetList = getChildTargets(parenetTargetId);
		} else {
			targetList = getTopLevelTargets(projectId);
		}
		String last2 = "";
		int last2int = 0;
		String temp2 = "";
		int temp2int = 0;
		for (int i = 0; i < targetList.size(); i++) {
			Targets target = (Targets) targetList.get(i);
			temp2 = target.getTargetOrder();
			temp2 = temp2.substring(temp2.length() - 2);
			temp2int = Integer.parseInt(temp2);
			if (temp2int > last2int) {
				last2int = temp2int;
			}
		}
		if (last2int == 0) {
			last2 = "01";
		} else {
			last2int++;
			if (last2int < 10) {
				last2 = "0" + last2int;
			} else {
				last2 = "" + last2int;
			}
		}
		if (parenetTargetId != null) {
			Targets parentTarget = getTargetById(parenetTargetId);
			return parentTarget.getTargetOrder() + last2;
		}
		else{
			return last2;
		}

	}

	public List getChildTargets(Long targetId) {
		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);
		targetQuery.setEQ("parentId", targetId);
		targetQuery.execute();
		List targetList = targetQuery.getResults();
		return targetList;
	}
	
	public List getAllChildAndItTargets(Targets target) {
		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);
		targetQuery.setEQ("projectId",target.getProjectId());
		targetQuery.setRightLIKE("targetOrder", target.getTargetOrder());
		targetQuery.setOrderBy("targetOrder","desc");
		targetQuery.execute();
		List targetList = targetQuery.getResults();
		return targetList;
	}

	public Targets getTargetById(Long targetId) {
		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);
		Targets target = (Targets) targetQuery.loadByID(Targets.class,
				targetId, false);
		return target;
	}
	
	public List getTopLevelTargets(Long projectId) {
		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);
		targetQuery.setEQ("projectId", projectId);
		targetQuery.setEQ("targetLevel",new Integer(1));
		targetQuery.execute();
		List targetList = targetQuery.getResults();
		return targetList;
	}
	
	public Long adjustTarget(Long targetId) {
		
		//return the parent target id of current target
		PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);
		Targets currentTarget = (Targets) targetQuery.loadByID(Targets.class,targetId, false);
		
		List targetList = null;
		Date startDateMin =new Date(3000,1,1);
		Date endDateMax =new Date(1,1,1);
		Date startDateTemp =new Date();
		Date endDateTemp =new Date();
		
		targetList = getChildTargets(targetId);
		if(targetList==null||targetList.size()==0){
			System.out.println("target :"+currentTarget.getTargetOrder() + " is not parent ");
			currentTarget.setIsParent(PMConstants.PARENT_N);
		}
		else{
			for (int i = 0; i < targetList.size(); i++) {
				Targets target = (Targets) targetList.get(i);
				startDateTemp=target.getStartDatePlan();
				endDateTemp=target.getEndDatePlan();
				if (startDateTemp!=null && startDateTemp.before(startDateMin)) {
					startDateMin = startDateTemp;
				}
				if (endDateTemp!=null && endDateTemp.after(endDateMax)) {
					endDateMax = endDateTemp;
				}
			}//for
			currentTarget.setIsParent(PMConstants.PARENT_Y);
			currentTarget.setStartDatePlan(startDateMin);
			currentTarget.setEndDatePlan(endDateMax);
		}//else
		
		// update current target
        TargetModifyBO bo=new TargetModifyBO(currentTarget);
		bo.execute();
		
		return currentTarget.getParentId();
	}
	
	

}
