/*
 * Created Mon Nov 27 23:59:50 CST 2006 by MyEclipse Hibernate Tool.
 */
package edu.pm.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import edu.dlmu.sei.util.LabelValue;

/**
 * A class that represents a row in the 'weeks' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Weeks
    extends AbstractWeeks
    implements Serializable, LabelValue
{
    /**
     * Simple constructor of Weeks instances.
     */
    public Weeks()
    {
    }

    /**
     * Constructor of Weeks instances given a simple primary key.
     * @param id
     */
    public Weeks(java.lang.Long id)
    {
        super(id);
    }

    /* Add customized code below */
    
   
    int workloadAll;

	public int getWorkloadAll() {

		int workdayThisWeek = 1 + (int)((this.getEndDate().getTime() - this.getStartDate().getTime()) / (long)(60*60*24*1000));
		
		return workdayThisWeek*this.getWorkloadPerDay().intValue();
	}

	public void setWorkloadAll(int workloadAll) {
		this.workloadAll = workloadAll;
	}

	public String getValue() {

		return this.getId().toString();
	}

	public String getLabel() {
		
		SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy-MM-dd");
		    
		String temp = myFmt1.format(this.getStartDate())+"_"+myFmt1.format(this.getEndDate());
		
		return temp;
		
	}

}
