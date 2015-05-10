
package edu.pm.uc.projectinfor.form;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseForm;
import edu.pm.vo.Projects;
import edu.pm.vo.Users;

/**
 * @author guo
 *
 */
public class ProjectForm extends PMBaseForm {


    /** The composite primary key value. */
    private java.lang.String id;

    /** The value of the users association. */
    private java.lang.String pmId ;

    /** The value of the simple projectCode property. */
    private java.lang.String projectCode;

    /** The value of the simple projectName property. */
    private java.lang.String projectName;

    /** The value of the simple projectGoal property. */
    private java.lang.String projectGoal;

    /** The value of the simple startDate property. */
    private String startDate;

    /** The value of the simple closeDate property. */
    private String closeDate;

    /** The value of the simple budget property. */
    private String budget;

    /** The value of the simple personCost property. */
    private String personCost;

    /** The value of the simple teamSize property. */
    private String teamSize;

    /** The value of the simple developRoof property. */
    private String developRoof;

    /** The value of the simple developLanguage property. */
    private java.lang.String developLanguage;

    /** The value of the simple status property. */
    private java.lang.String status;

    /** The value of the simple isDeleted property. */
    private java.lang.String isDeleted;
    
    private String userList ;

	public String getUserList() {
		return userList;
	}

	public void setUserList(String userList) {
		this.userList = userList;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		if(closeDate!=null){
			this.closeDate = closeDate.trim();
		}
		else{
			this.closeDate = null;
		}
	}

	public java.lang.String getDevelopLanguage() {
		return developLanguage;
	}

	public void setDevelopLanguage(java.lang.String developLanguage) {
		this.developLanguage = developLanguage;
	}

	public String getDevelopRoof() {
		return developRoof;
	}

	public void setDevelopRoof(String developRoof) {
		this.developRoof = developRoof;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(java.lang.String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getPersonCost() {
		return personCost;
	}

	public void setPersonCost(String personCost) {
		this.personCost = personCost;
	}

	public java.lang.String getPmId() {
		return pmId;
	}

	public void setPmId(java.lang.String pmId) {
		this.pmId = pmId;
	}

	public java.lang.String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(java.lang.String projectCode) {
		this.projectCode = projectCode;
	}

	public java.lang.String getProjectGoal() {
		return projectGoal;
	}

	public void setProjectGoal(java.lang.String projectGoal) {
		this.projectGoal = projectGoal;
	}

	public java.lang.String getProjectName() {
		return projectName;
	}

	public void setProjectName(java.lang.String projectName) {
		this.projectName = projectName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		if(startDate!=null){
			this.startDate = startDate.trim();
		}
		else{
			this.startDate = null;
		}
	}

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public String getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(String teamSize) {
		this.teamSize = teamSize;
	}
	
	public Projects getVo() {
		
		Projects vo = new Projects();

		if (null != id && !"".equals(id)){
			vo.setId(new Long(id));
		}
		if (null != pmId && !"".equals(pmId)){
			vo.setPmId(new Long(pmId));
		}
		if (null != budget && !"".equals(budget)){
			vo.setBudget(new Double(budget));
		}
		if (null != personCost && !"".equals(personCost)){
			vo.setPersonCost(new Double(personCost));
		}
		if (null != teamSize && !"".equals(teamSize)){
			vo.setTeamSize(new Integer(teamSize));
		}
		if (null !=closeDate && !closeDate.trim().equals("")) {
			vo.setCloseDate(CoreUtils.parseDate(closeDate.trim()));
		}
		if (null !=startDate && !startDate.trim().equals("")) {
			vo.setStartDate(CoreUtils.parseDate(startDate.trim()));
		}
		vo.setProjectCode(this.getProjectCode());
		vo.setProjectName(this.getProjectName());
		vo.setProjectGoal(this.getProjectGoal());
		vo.setDevelopRoof(this.getDevelopRoof());
		vo.setDevelopLanguage(this.getDevelopLanguage());
		vo.setStatus(this.getStatus());
		vo.setIsDeleted(this.getIsDeleted());
		return vo;
	}

	public void setVO(Projects vo) {
		
		SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy-MM-dd");
		java.text.DecimalFormat format = new java.text.DecimalFormat("#############0.00");
		
		if (null != vo.getId()){
			setId(vo.getId().toString());
		}
		if (null != vo.getPmId()){
			setPmId(vo.getPmId().toString());
		}
		if (null != vo.getBudget()){
			setBudget(format.format(vo.getBudget()));
		}
		if (null != vo.getPersonCost()){
			setPersonCost(format.format(vo.getPersonCost()));
		}
		if (null != vo.getTeamSize()){
			setTeamSize(vo.getTeamSize().toString());
		}
		if (null != vo.getCloseDate()) {
			setCloseDate(myFmt1.format(vo.getCloseDate()));
		}
		if (null != vo.getStartDate()) {
			setStartDate(myFmt1.format(vo.getStartDate()));
		}
		
		if (null != vo.getUserList() && vo.getUserList().size()>0) {
			Iterator userIt = vo.getUserList().values().iterator();
			String temp="";
			while(userIt.hasNext()){
				Users user =(Users) userIt.next();
				String userName = user.getUserName();
				temp=temp+", "+userName+" ";
			}
			if(temp.length()>0){
				temp=temp.substring(1);
			}
			setUserList(temp);
			
		}
		setProjectCode(vo.getProjectCode());
		setProjectName(vo.getProjectName());
		setProjectGoal(vo.getProjectGoal());
		setDevelopRoof(vo.getDevelopRoof());
		setDevelopLanguage(vo.getDevelopLanguage());
		setStatus(vo.getStatus());
		setIsDeleted(vo.getIsDeleted());
		
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		super.reset(mapping, request);

	}

	public ActionErrors validate(ActionMapping mapping,

	HttpServletRequest request) {

		ActionErrors errors = super.validate(mapping, request);
		// date before check
		if((!isValidDate(startDate))||(!isValidDate(closeDate))){
			return errors;
		}
		
		java.util.Date s=CoreUtils.parseDate(startDate.trim());
		java.util.Date e=CoreUtils.parseDate(closeDate.trim());
		
		if(s==null||e==null){
			return errors;
		}
		
		if(e.before(s)){
			errors.add("closeDate", new ActionMessage("DateAfter"));
			return errors;
		}

		return errors;

	}
	

	 public static boolean isValidDate(String dateStr) {
	   try {
	    Date.valueOf(dateStr.trim());
	    return true;
	   } catch (Exception e) {
	    return false;
	   }
	 }

}
