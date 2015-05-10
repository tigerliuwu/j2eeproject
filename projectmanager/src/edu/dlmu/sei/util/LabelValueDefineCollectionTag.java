package edu.dlmu.sei.util;

import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class LabelValueDefineCollectionTag extends TagSupport {

	protected String id = null;

	protected String labelvalue = null;

	protected String scope = null;

	public int doEndTag() throws JspException {

		System.out.println("labelvalue---------------- : "+labelvalue);
		
		ConstantsContainer constantsCache = ConstantsContainer.getInstants();

		Collection col = constantsCache.getCollection(labelvalue);

		pageContext.setAttribute(id, col, PageContext.PAGE_SCOPE);

		return (EVAL_PAGE);
	}

	public void release() {

		id = null;
		labelvalue = null;
		scope = null;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabelvalue() {
		return labelvalue;
	}

	public void setLabelvalue(String labelvalue) {
		this.labelvalue = labelvalue;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
