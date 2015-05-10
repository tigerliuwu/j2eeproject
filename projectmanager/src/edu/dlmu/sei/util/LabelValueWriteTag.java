package edu.dlmu.sei.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

public class LabelValueWriteTag extends TagSupport {

	private String name = null;

	private String property = null;

	private String labelvalue = null;

	protected String scope = null;

	public String getScope() {
		return (this.scope);
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public int doEndTag() throws JspException {
		ConstantsContainer constantsCache = ConstantsContainer.getInstants();

		Object value1 = TagUtils.getInstance().lookup(pageContext, name,
				property, scope);

		if (value1 == null || value1.equals("")) {
			TagUtils.getInstance().write(pageContext, "");

		} else {
			String value = constantsCache.getLabel(labelvalue, value1
					.toString());

			if (value == null) {
				TagUtils.getInstance().write(pageContext, value1.toString());
			} else {
				TagUtils.getInstance().write(pageContext, value);
			}
		}

		return (EVAL_PAGE);
	}

	public void release() {

		super.release();
		name = null;
		labelvalue = null;
		property = null;
		scope = null;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabelvalue() {
		return labelvalue;
	}

	public void setLabelvalue(String labelvalue) {
		this.labelvalue = labelvalue;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

}
