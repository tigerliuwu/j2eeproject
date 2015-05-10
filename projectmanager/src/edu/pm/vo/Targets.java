/*
 * Created Mon Nov 27 23:59:23 CST 2006 by MyEclipse Hibernate Tool.
 */
package edu.pm.vo;

import java.io.Serializable;

/**
 * A class that represents a row in the 'targets' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Targets
    extends AbstractTargets
    implements Serializable
{
    /**
     * Simple constructor of Targets instances.
     */
    public Targets()
    {
    }

    /**
     * Constructor of Targets instances given a simple primary key.
     * @param id
     */
    public Targets(java.lang.Long id)
    {
        super(id);
    }

    /* Add customized code below */
    
    public String toString(){
    	return this.getTargetName();
    }
    
    private boolean Draw;

	public boolean getDraw() {
		return Draw;
	}

	public void setDraw(boolean draw) {
		Draw = draw;
	}
	
	 private boolean Selected;

	public boolean getSelected() {
		return Selected;
	}

	public void setSelected(boolean selected) {
		Selected = selected;
	}
	
	 private boolean hasReport;

	public boolean isHasReport() {
		return hasReport;
	}

	public void setHasReport(boolean hasReport) {
		this.hasReport = hasReport;
	}
   
}
