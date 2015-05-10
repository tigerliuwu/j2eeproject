/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Mon Nov 27 23:59:32 CST 2006 by MyEclipse Hibernate Tool.
 */
package edu.pm.vo;

import java.io.Serializable;

/**
 * A class that represents a row in the user_role table. 
 * You can customize the behavior of this class by editing the class, {@link UserRole()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractUserRole 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.Long id;

    /** The value of the users association. */
    private java.lang.Long userId;

    /** The value of the roles association. */
    private java.lang.Long roleId;

    /** The value of the projects association. */
    private java.lang.Long projectId;

    /** The value of the simple isWorking property. */
    private java.lang.String isWorking;

    /**
     * Simple constructor of AbstractUserRole instances.
     */
    public AbstractUserRole()
    {
    }

    /**
     * Constructor of AbstractUserRole instances given a simple primary key.
     * @param id
     */
    public AbstractUserRole(java.lang.Long id)
    {
        this.setId(id);
    }

    /**
     * Return the simple primary key value that identifies this object.
     * @return java.lang.Long
     */
    public java.lang.Long getId()
    {
        return id;
    }

    /**
     * Set the simple primary key value that identifies this object.
     * @param id
     */
    public void setId(java.lang.Long id)
    {
        this.hashValue = 0;
        this.id = id;
    }

    

    public java.lang.Long getProjectId() {
		return projectId;
	}

	public void setProjectId(java.lang.Long projectId) {
		this.projectId = projectId;
	}

	public java.lang.Long getRoleId() {
		return roleId;
	}

	public void setRoleId(java.lang.Long roleId) {
		this.roleId = roleId;
	}

	public java.lang.Long getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}

	/**
     * Return the value of the is_working column.
     * @return java.lang.String
     */
    public java.lang.String getIsWorking()
    {
        return this.isWorking;
    }

    /**
     * Set the value of the is_working column.
     * @param isWorking
     */
    public void setIsWorking(java.lang.String isWorking)
    {
        this.isWorking = isWorking;
    }

    /**
     * Implementation of the equals comparison on the basis of equality of the primary key values.
     * @param rhs
     * @return boolean
     */
    public boolean equals(Object rhs)
    {
        if (rhs == null)
            return false;
        if (! (rhs instanceof UserRole))
            return false;
        UserRole that = (UserRole) rhs;
        if (this.getId() != null && that.getId() != null)
        {
            if (! this.getId().equals(that.getId()))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Implementation of the hashCode method conforming to the Bloch pattern with
     * the exception of array properties (these are very unlikely primary key types).
     * @return int
     */
    public int hashCode()
    {
        if (this.hashValue == 0)
        {
            int result = 17;
            int idValue = this.getId() == null ? 0 : this.getId().hashCode();
            result = result * 37 + idValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
}
