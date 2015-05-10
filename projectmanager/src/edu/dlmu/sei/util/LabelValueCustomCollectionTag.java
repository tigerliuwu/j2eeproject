package edu.dlmu.sei.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import edu.dlmu.sei.util.ConstantsParameterContainer;

public class LabelValueCustomCollectionTag extends TagSupport {

	protected String id = null;

	private String name = null;

	private String property1 = null;

	private String property2 = null;

	protected String labelvalue = null;

	protected String scope = null;

	protected String value = null;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int doEndTag() throws JspException {
		String parameter1="";
		
		String parameter2="";
		
		if (value == null || value.equals("")) {
			parameter1 = TagUtils.getInstance().lookup(pageContext, name,
					property1, scope).toString();

			parameter2 = TagUtils.getInstance().lookup(pageContext, name,
					property2, scope).toString();
		}else{
			parameter1 = value;
		}

		if (StringUtils.isBlank(parameter1))
			throw new JspException();

		ConstantsParameterContainer parameterContainer = new ConstantsParameterContainer(
				labelvalue, parameter1, parameter2);

		parameterContainer.execute();

		pageContext.setAttribute(id, parameterContainer.getResults(),
				PageContext.PAGE_SCOPE);

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProperty1() {
		return property1;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}

	public String getProperty2() {
		return property2;
	}

	public void setProperty2(String property2) {
		this.property2 = property2;
	}

}
