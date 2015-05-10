/*
 * Created Mon Nov 27 23:58:20 CST 2006 by MyEclipse Hibernate Tool.
 */
package edu.pm.vo;

import java.io.Serializable;

import edu.dlmu.sei.util.LabelValue;

/**
 * A class that represents a row in the 'permissions' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Permissions
    extends AbstractPermissions
    implements Serializable,LabelValue
{
    /**
     * Simple constructor of Permissions instances.
     */
    public Permissions()
    {
    }

    /**
     * Constructor of Permissions instances given a simple primary key.
     * @param id
     */
    public Permissions(java.lang.Long id)
    {
        super(id);
    }

	public String getValue() {
		// TODO Auto-generated method stub
		return this.getId().toString();
	}

	public String getLabel() {
		// TODO Auto-generated method stub
		return this.getPermissionName();
	}

    /* Add customized code below */
	
	String checked;

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

}
