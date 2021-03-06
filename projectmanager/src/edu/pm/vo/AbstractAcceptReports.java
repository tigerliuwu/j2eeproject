/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Mon Nov 27 23:55:56 CST 2006 by MyEclipse Hibernate Tool.
 */
package edu.pm.vo;

import java.io.Serializable;

/**
 * A class that represents a row in the accept_reports table. 
 * You can customize the behavior of this class by editing the class, {@link AcceptReports()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractAcceptReports 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.Long id;

    /** The value of the projects association. */
    private Long projectId;

    /** The value of the simple projectSummarize property. */
    private java.lang.String projectSummarize;

    /** The value of the simple workloadPlan property. */
    private java.lang.Integer workloadPlan;

    /** The value of the simple estimateSize property. */
    private java.lang.Integer estimateSize;

    /** The value of the simple workloadFact property. */
    private java.lang.Integer workloadFact;

    /** The value of the simple estimateRemark property. */
    private java.lang.String estimateRemark;

    /** The value of the simple risk1 property. */
    private java.lang.String risk1;

    /** The value of the simple risk2 property. */
    private java.lang.String risk2;

    /** The value of the simple risk3 property. */
    private java.lang.String risk3;

    /** The value of the simple experience property. */
    private java.lang.String experience;

    /** The value of the simple acceptCommment property. */
    private java.lang.String acceptCommment;

    /** The value of the simple acceptBy property. */
    private java.lang.String acceptBy;

    /** The value of the simple acceptDate property. */
    private java.util.Date acceptDate;

    /** The value of the simple acceptResult property. */
    private java.lang.String acceptResult;

    /**
     * Simple constructor of AbstractAcceptReports instances.
     */
    public AbstractAcceptReports()
    {
    }

    /**
     * Constructor of AbstractAcceptReports instances given a simple primary key.
     * @param id
     */
    public AbstractAcceptReports(java.lang.Long id)
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

  
    public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
     * Return the value of the project_summarize column.
     * @return java.lang.String
     */
    public java.lang.String getProjectSummarize()
    {
        return this.projectSummarize;
    }

    /**
     * Set the value of the project_summarize column.
     * @param projectSummarize
     */
    public void setProjectSummarize(java.lang.String projectSummarize)
    {
        this.projectSummarize = projectSummarize;
    }

    /**
     * Return the value of the workload_plan column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getWorkloadPlan()
    {
        return this.workloadPlan;
    }

    /**
     * Set the value of the workload_plan column.
     * @param workloadPlan
     */
    public void setWorkloadPlan(java.lang.Integer workloadPlan)
    {
        this.workloadPlan = workloadPlan;
    }

    /**
     * Return the value of the estimate_size column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getEstimateSize()
    {
        return this.estimateSize;
    }

    /**
     * Set the value of the estimate_size column.
     * @param estimateSize
     */
    public void setEstimateSize(java.lang.Integer estimateSize)
    {
        this.estimateSize = estimateSize;
    }

    /**
     * Return the value of the workload_fact column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getWorkloadFact()
    {
        return this.workloadFact;
    }

    /**
     * Set the value of the workload_fact column.
     * @param workloadFact
     */
    public void setWorkloadFact(java.lang.Integer workloadFact)
    {
        this.workloadFact = workloadFact;
    }

    /**
     * Return the value of the estimate_remark column.
     * @return java.lang.String
     */
    public java.lang.String getEstimateRemark()
    {
        return this.estimateRemark;
    }

    /**
     * Set the value of the estimate_remark column.
     * @param estimateRemark
     */
    public void setEstimateRemark(java.lang.String estimateRemark)
    {
        this.estimateRemark = estimateRemark;
    }

    /**
     * Return the value of the risk1 column.
     * @return java.lang.String
     */
    public java.lang.String getRisk1()
    {
        return this.risk1;
    }

    /**
     * Set the value of the risk1 column.
     * @param risk1
     */
    public void setRisk1(java.lang.String risk1)
    {
        this.risk1 = risk1;
    }

    /**
     * Return the value of the risk2 column.
     * @return java.lang.String
     */
    public java.lang.String getRisk2()
    {
        return this.risk2;
    }

    /**
     * Set the value of the risk2 column.
     * @param risk2
     */
    public void setRisk2(java.lang.String risk2)
    {
        this.risk2 = risk2;
    }

    /**
     * Return the value of the risk3 column.
     * @return java.lang.String
     */
    public java.lang.String getRisk3()
    {
        return this.risk3;
    }

    /**
     * Set the value of the risk3 column.
     * @param risk3
     */
    public void setRisk3(java.lang.String risk3)
    {
        this.risk3 = risk3;
    }

    /**
     * Return the value of the experience column.
     * @return java.lang.String
     */
    public java.lang.String getExperience()
    {
        return this.experience;
    }

    /**
     * Set the value of the experience column.
     * @param experience
     */
    public void setExperience(java.lang.String experience)
    {
        this.experience = experience;
    }

    /**
     * Return the value of the accept_commment column.
     * @return java.lang.String
     */
    public java.lang.String getAcceptCommment()
    {
        return this.acceptCommment;
    }

    /**
     * Set the value of the accept_commment column.
     * @param acceptCommment
     */
    public void setAcceptCommment(java.lang.String acceptCommment)
    {
        this.acceptCommment = acceptCommment;
    }

    /**
     * Return the value of the accept_by column.
     * @return java.lang.String
     */
    public java.lang.String getAcceptBy()
    {
        return this.acceptBy;
    }

    /**
     * Set the value of the accept_by column.
     * @param acceptBy
     */
    public void setAcceptBy(java.lang.String acceptBy)
    {
        this.acceptBy = acceptBy;
    }

    /**
     * Return the value of the accept_date column.
     * @return java.util.Date
     */
    public java.util.Date getAcceptDate()
    {
        return this.acceptDate;
    }

    /**
     * Set the value of the accept_date column.
     * @param acceptDate
     */
    public void setAcceptDate(java.util.Date acceptDate)
    {
        this.acceptDate = acceptDate;
    }

    /**
     * Return the value of the accept_result column.
     * @return java.lang.String
     */
    public java.lang.String getAcceptResult()
    {
        return this.acceptResult;
    }

    /**
     * Set the value of the accept_result column.
     * @param acceptResult
     */
    public void setAcceptResult(java.lang.String acceptResult)
    {
        this.acceptResult = acceptResult;
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
        if (! (rhs instanceof AcceptReports))
            return false;
        AcceptReports that = (AcceptReports) rhs;
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
