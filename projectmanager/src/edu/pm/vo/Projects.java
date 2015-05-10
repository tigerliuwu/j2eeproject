/*
 * Created Mon Nov 27 23:58:58 CST 2006 by MyEclipse Hibernate Tool.
 */
package edu.pm.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.dlmu.sei.util.LabelValue;
import edu.pm.base.PMBaseQuery;
import edu.pm.constants.PMConstants;

/**
 * A class that represents a row in the 'projects' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Projects
    extends AbstractProjects
    implements Serializable ,LabelValue
{
    /**
     * Simple constructor of Projects instances.
     */
    public Projects()
    {
    }

    /**
     * Constructor of Projects instances given a simple primary key.
     * @param id
     */
    public Projects(java.lang.Long id)
    {
        super(id);
    }

    /* Add customized code below */

    public int leftDays;
    
	public int getLeftDays() {		
		Date close = this.getCloseDate();		
		Date today = new Date();		
		long sub = close.getTime()-today.getTime();		
		long day = sub/(long)(24*60*60*1000);		
		return (int)day;	
	}	
	
	public void setLeftDays(int leftDays) {		
		this.leftDays = leftDays;	
	}	
	
	public int userCount;

	public int getUserCount() {
		
		return this.getUserList().size();
		
	}

	public void setUserCount(int userCount) {
		
		this.userCount = userCount;
		
	}
	
	public int targetCount;

	public int getTargetCount() {
		return targetCount;
	}

	public void setTargetCount(int targetCount) {
		this.targetCount = targetCount;
	}

	public String getValue() {
		
		return this.getId().toString();
	}

	public String getLabel() {
		
		return this.getProjectName();
	}
	
	private Set userList;

	public Map getUserList() {
		
		HashMap userMap = new HashMap();
		
		PMBaseQuery userRoleQuery = new PMBaseQuery(UserRole.class);
		
		userRoleQuery.setLazy(true);
		
		userRoleQuery.setEQ("projectId",this.getId());
		
		userRoleQuery.setEQ("roleId",PMConstants.ROLE_SE);
		
		userRoleQuery.execute();
		
		List userRoleList = userRoleQuery.getResults();
		
		for(int i=0;i<userRoleList.size();i++){
			
			UserRole userRole = (UserRole)userRoleList.get(i);
			Users user = (Users)ConstantsContainer.getInstants().getVO(PMConstants.Users,userRole.getUserId().toString());
			if(!userMap.containsKey(userRole.getUserId())){
				userMap.put(userRole.getUserId(),user);
			}
			
		}
		
		return userMap;
	}

	public void setUserList(Set userList) {
		this.userList = userList;
	}
	
	
}
