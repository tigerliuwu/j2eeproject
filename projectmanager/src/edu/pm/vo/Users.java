/*
 * Created Mon Nov 27 23:59:38 CST 2006 by MyEclipse Hibernate Tool.
 */
package edu.pm.vo;

import java.io.Serializable;

import edu.dlmu.sei.util.LabelValue;

/**
 * A class that represents a row in the 'users' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Users
    extends AbstractUsers
    implements Serializable, LabelValue,Comparable
{
    /**
     * Simple constructor of Users instances.
     */
    public Users()
    {
    }

    /**
     * Constructor of Users instances given a simple primary key.
     * @param id
     */
    public Users(java.lang.Long id)
    {
        super(id);
    }

	public String getValue() {
		// TODO Auto-generated method stub
		return this.getId().toString();
	}

	public String getLabel() {
		// TODO Auto-generated method stub
		return this.getUserName();
	}

	public int compareTo(Object arg0) {
		Users that = (Users) arg0;
		if (this.getUserName() == null || that.getUserName() == null) {
			return this.getUserName().compareTo(that.getUserName());
		} else {
			return this.getId().compareTo(that.getId());
		}
	}

    /* Add customized code below */

}
