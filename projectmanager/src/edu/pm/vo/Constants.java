/*
 * Created Mon Nov 27 23:57:42 CST 2006 by MyEclipse Hibernate Tool.
 */
package edu.pm.vo;

import java.io.Serializable;

import edu.dlmu.sei.util.LabelValue;

/**
 * A class that represents a row in the 'constants' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Constants
    extends AbstractConstants
    implements Serializable ,LabelValue,Comparable
{
    /**
     * Simple constructor of Constants instances.
     */
    public Constants()
    {
    }

    /**
     * Constructor of Constants instances given a simple primary key.
     * @param id
     */
    public Constants(java.lang.Long id)
    {
        super(id);
    }

	public String getValue() {
		// TODO Auto-generated method stub
		return this.getConstantValue();
	}

	public String getLabel() {
		// TODO Auto-generated method stub
		return this.getConstantLabel();
	}
	
	public int compareTo(Object arg0) {
		Constants that = (Constants) arg0;
		if (this.getConstantOrder() == null || that.getConstantOrder() == null) {
			return this.getValue().compareTo(that.getValue());
		} else {
			return this.getConstantOrder().compareTo(that.getConstantOrder());
		}

	}

    /* Add customized code below */

}
