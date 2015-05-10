package edu.pm.vo;

import java.io.Serializable;

/**
 * This is the object class that relates to the PUB_WARNING table.
 * Any customizations belong here.
 */
public class test1 implements Serializable {

	public test1 () {}
	
	private java.lang.Long id  ;
	private java.lang.String param1;
	private java.lang.String param2;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getParam1() {
		return param1;
	}

	public void setParam1(java.lang.String param1) {
		this.param1 = param1;
	}

	public java.lang.String getParam2() {
		return param2;
	}

	public void setParam2(java.lang.String param2) {
		this.param2 = param2;
	}

	/**
	 * Constructor for primary key
	 */
	public test1 (java.lang.Long id) {
		this.setId(id);
	}
}


