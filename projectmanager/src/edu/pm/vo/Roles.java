/*
 * Created Mon Nov 27 23:59:17 CST 2006 by MyEclipse Hibernate Tool.
 */
package edu.pm.vo;

import java.io.Serializable;

import edu.dlmu.sei.util.LabelValue;

/**
 * A class that represents a row in the 'roles' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Roles
    extends AbstractRoles
    implements Serializable,LabelValue
{
    /**
     * Simple constructor of Roles instances.
     */
    public Roles()
    {
    }

    /**
     * Constructor of Roles instances given a simple primary key.
     * @param id
     */
    public Roles(java.lang.Long id)
    {
        super(id);
    }

	public String getValue() {
		// TODO Auto-generated method stub
		return this.getId().toString();
	}

	public String getLabel() {
		// TODO Auto-generated method stub
		return this.getRemark();
	}

    /* Add customized code below */

}
