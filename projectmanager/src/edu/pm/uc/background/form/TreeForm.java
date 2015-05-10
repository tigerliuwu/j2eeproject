package edu.pm.uc.background.form;

import java.io.Serializable;


public class TreeForm implements Serializable{

	
	private String text;

	private String treeid;

	private String parentid;

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTreeid() {
		return treeid;
	}

	public void setTreeid(String treeid) {
		this.treeid = treeid;
	}

	

}

