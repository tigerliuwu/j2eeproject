package edu.dlmu.sei.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

public class LabelValueDefineTag extends TagSupport {

	protected String id = null;

	protected String name = null;

	protected String property = null;

	protected String labelvalue = null;

	protected String scope = null;

	public int doEndTag() throws JspException {

		ConstantsContainer constantsCache = ConstantsContainer.getInstants();

		Object value1 =  TagUtils.getInstance().lookup(pageContext, name,
				property, scope);

		Object obj = constantsCache.getVO(labelvalue, value1.toString());

		pageContext.setAttribute(id, obj, PageContext.PAGE_SCOPE);

		return (EVAL_PAGE);
	}

	public void release() {

		super.release();
		name = null;
		labelvalue = null;
		property = null;
		id = null;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
