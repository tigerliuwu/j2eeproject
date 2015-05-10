/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.projectlist.form;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseForm;

/**
 * This class is used for the management certificate battery basic information function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class HumanResSearchForm extends PMBaseForm {

	private String startDate;
	
	private String endDate;


	public ActionErrors validate(ActionMapping mapping,

	HttpServletRequest request) {

		ActionErrors errors = super.validate(mapping, request);
		// date before check
		if((!isValidDate(startDate))||(!isValidDate(endDate))){
			return errors;
		}
		
		java.util.Date s=CoreUtils.parseDate(startDate.trim());
		java.util.Date e=CoreUtils.parseDate(endDate.trim());
		
		if(s==null||e==null){
			return errors;
		}
		
		System.out.println("s:"+s);
		System.out.println("e:"+e);
		
		if(e.before(s)){
			errors.add("expiredDate", new ActionMessage("DateAfter"));
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


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}
