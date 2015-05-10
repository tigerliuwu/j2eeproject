/*
 * Created Mon Nov 27 23:59:32 CST 2006 by MyEclipse Hibernate Tool.
 */
package edu.pm.vo;

import java.io.Serializable;

import edu.dlmu.sei.util.ConstantsContainer;
import edu.pm.constants.PMConstants;

/**
 * A class that represents a row in the 'user_role' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class UserRole
    extends AbstractUserRole
    implements Serializable
{
    /**
     * Simple constructor of UserRole instances.
     */
    public UserRole()
    {
    }

    /**
     * Constructor of UserRole instances given a simple primary key.
     * @param id
     */
    public UserRole(java.lang.Long id)
    {
        super(id);
    }

    /* Add customized code below */
    
    public Users getUser(){
    	return (Users) ConstantsContainer.getInstants().getVO(
				PMConstants.Users, this.getUserId().toString());
    }
    public Roles getRole(){
    	return (Roles) ConstantsContainer.getInstants().getVO(
				PMConstants.Roles, this.getRoleId().toString());
    }

}
