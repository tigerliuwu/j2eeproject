
package edu.pm.uc.teamset.form;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseForm;
import edu.pm.constants.PMConstants;
import edu.pm.vo.Projects;
import edu.pm.vo.Users;

/**
 * @author guo
 *
 */
public class TeamForm extends PMBaseForm {

	private String userList;
	
	private String teamList;
	
	private String notTeamList;

	public String getNotTeamList() {
		return notTeamList;
	}

	public void setNotTeamList(String notTeamList) {
		this.notTeamList = notTeamList;
	}

	public String getTeamList() {
		return teamList;
	}

	public void setTeamList(String teamList) {
		this.teamList = teamList;
	}

	public String getUserList() {
		return userList;
	}

	public void setUserList(String userList) {
		this.userList = userList;
	}
	
}
