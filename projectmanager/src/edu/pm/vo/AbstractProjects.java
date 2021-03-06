/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Mon Nov 27 23:58:58 CST 2006 by MyEclipse Hibernate Tool.
 */
package edu.pm.vo;

import java.io.Serializable;

/**
 * A class that represents a row in the projects table. 
 * You can customize the behavior of this class by editing the class, {@link Projects()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractProjects 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.Long id;

    /** The value of the users association. */
    private java.lang.Long pmId ;

    /** The value of the simple projectCode property. */
    private java.lang.String projectCode;

    /** The value of the simple projectName property. */
    private java.lang.String projectName;

    /** The value of the simple projectGoal property. */
    private java.lang.String projectGoal;

    /** The value of the simple startDate property. */
    private java.util.Date startDate;

    /** The value of the simple closeDate property. */
    private java.util.Date closeDate;

    /** The value of the simple budget property. */
    private java.lang.Double budget;

    /** The value of the simple personCost property. */
    private java.lang.Double personCost;

    /** The value of the simple teamSize property. */
    private java.lang.Integer teamSize;

    /** The value of the simple developRoof property. */
    private java.lang.String developRoof;

    /** The value of the simple developLanguage property. */
    private java.lang.String developLanguage;

    /** The value of the simple status property. */
    private java.lang.String status;

    /** The value of the simple isDeleted property. */
    private java.lang.String isDeleted;

    /**
     * Simple constructor of AbstractProjects instances.
     */
    public AbstractProjects()
    {
    }

    /**
     * Constructor of AbstractProjects instances given a simple primary key.
     * @param id
     */
    public AbstractProjects(java.lang.Long id)
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

    /**
     * Return the value of the project_code column.
     * @return java.lang.String
     */
    public java.lang.String getProjectCode()
    {
        return this.projectCode;
    }

    /**
     * Set the value of the project_code column.
     * @param projectCode
     */
    public void setProjectCode(java.lang.String projectCode)
    {
        this.projectCode = projectCode;
    }

    /**
     * Return the value of the project_name column.
     * @return java.lang.String
     */
    public java.lang.String getProjectName()
    {
        return this.projectName;
    }

    /**
     * Set the value of the project_name column.
     * @param projectName
     */
    public void setProjectName(java.lang.String projectName)
    {
        this.projectName = projectName;
    }

    /**
     * Return the value of the project_goal column.
     * @return java.lang.String
     */
    public java.lang.String getProjectGoal()
    {
        return this.projectGoal;
    }

    /**
     * Set the value of the project_goal column.
     * @param projectGoal
     */
    public void setProjectGoal(java.lang.String projectGoal)
    {
        this.projectGoal = projectGoal;
    }

   
    public java.lang.Long getPmId() {
		return pmId;
	}

	public void setPmId(java.lang.Long pmId) {
		this.pmId = pmId;
	}

	/**
     * Return the value of the start_date column.
     * @return java.util.Date
     */
    public java.util.Date getStartDate()
    {
        return this.startDate;
    }

    /**
     * Set the value of the start_date column.
     * @param startDate
     */
    public void setStartDate(java.util.Date startDate)
    {
        this.startDate = startDate;
    }

    /**
     * Return the value of the close_date column.
     * @return java.util.Date
     */
    public java.util.Date getCloseDate()
    {
        return this.closeDate;
    }

    /**
     * Set the value of the close_date column.
     * @param closeDate
     */
    public void setCloseDate(java.util.Date closeDate)
    {
        this.closeDate = closeDate;
    }

    /**
     * Return the value of the budget column.
     * @return java.lang.Double
     */
    public java.lang.Double getBudget()
    {
        return this.budget;
    }

    /**
     * Set the value of the budget column.
     * @param budget
     */
    public void setBudget(java.lang.Double budget)
    {
        this.budget = budget;
    }

    /**
     * Return the value of the person_cost column.
     * @return java.lang.Double
     */
    public java.lang.Double getPersonCost()
    {
        return this.personCost;
    }

    /**
     * Set the value of the person_cost column.
     * @param personCost
     */
    public void setPersonCost(java.lang.Double personCost)
    {
        this.personCost = personCost;
    }

    /**
     * Return the value of the team_size column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getTeamSize()
    {
        return this.teamSize;
    }

    /**
     * Set the value of the team_size column.
     * @param teamSize
     */
    public void setTeamSize(java.lang.Integer teamSize)
    {
        this.teamSize = teamSize;
    }

    /**
     * Return the value of the develop_roof column.
     * @return java.lang.String
     */
    public java.lang.String getDevelopRoof()
    {
        return this.developRoof;
    }

    /**
     * Set the value of the develop_roof column.
     * @param developRoof
     */
    public void setDevelopRoof(java.lang.String developRoof)
    {
        this.developRoof = developRoof;
    }

    /**
     * Return the value of the develop_language column.
     * @return java.lang.String
     */
    public java.lang.String getDevelopLanguage()
    {
        return this.developLanguage;
    }

    /**
     * Set the value of the develop_language column.
     * @param developLanguage
     */
    public void setDevelopLanguage(java.lang.String developLanguage)
    {
        this.developLanguage = developLanguage;
    }

    /**
     * Return the value of the status column.
     * @return java.lang.String
     */
    public java.lang.String getStatus()
    {
        return this.status;
    }

    /**
     * Set the value of the status column.
     * @param status
     */
    public void setStatus(java.lang.String status)
    {
        this.status = status;
    }

    /**
     * Return the value of the is_deleted column.
     * @return java.lang.String
     */
    public java.lang.String getIsDeleted()
    {
        return this.isDeleted;
    }

    /**
     * Set the value of the is_deleted column.
     * @param isDeleted
     */
    public void setIsDeleted(java.lang.String isDeleted)
    {
        this.isDeleted = isDeleted;
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
        if (! (rhs instanceof Projects))
            return false;
        Projects that = (Projects) rhs;
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
