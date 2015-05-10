package edu.pm.uc.weekset.bo;

import java.util.Date;
import java.util.List;

import edu.pm.base.PMBaseBusinessObject;
import edu.pm.base.PMBaseQuery;
import edu.pm.uc.weekset.exception.WeekException;
import edu.pm.vo.Weeks;

public class WeekCheckBO extends PMBaseBusinessObject {

	private Weeks vo;

	public WeekCheckBO(Weeks vo) {

		this.vo = vo;

	}

	protected void performBusinessLogic() {

		Date startDate00 = vo.getStartDate();
		
		Date endDate00 = vo.getEndDate();
		
		PMBaseQuery weekQuery = new PMBaseQuery(Weeks.class);
		
		weekQuery.setEQ("projectId",vo.getProjectId().toString());
		
		weekQuery.execute();
		
		List weekList = weekQuery.getResults();
		
		for(int i=0;i<weekList.size();i++){
			Weeks week = (Weeks)weekList.get(i);
			Date startDate = week.getStartDate();
			Date endDate = week.getEndDate();
			if (!(startDate00.after(endDate) || endDate00.before(startDate))){
				if(vo.getId()!=null){
					if(!vo.getId().equals(week.getId())){
						throw new WeekException("指定的时间段与已有工作周冲突");
					}
				}else{
					throw new WeekException("指定的时间段与已有工作周冲突");
				}
				
			}
		}

	}

}
