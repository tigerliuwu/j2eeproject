package edu.dlmu.sei.util;

import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import edu.pm.vo.Constants;

public class LabelValueRadioTag extends TagSupport {
	private String name = null;

	private String property = null;

	private String labelvalue = null;

	protected String scope = null;
	
	protected String onClick = null;

	public int doEndTag() throws JspException {
		ConstantsContainer constantsCache = ConstantsContainer.getInstants();

		Object value1 = TagUtils.getInstance().lookup(pageContext, name,
				property, scope);

		Iterator it = constantsCache.getCollection(labelvalue).iterator();

		String str = "";

		while (it.hasNext()) {

			Constants vo = (Constants) it.next();

			str += "<input type=\"radio\" name=\"" + property + "\" value=\""
					+ vo.getValue() + "\" ";

			if(onClick!=null){
				str +=" onClick=\""+onClick+"\" ";
			}
			
			if (value1 != null) {
				if (vo.getValue().equals(value1.toString())) {
					str += "checked >" + vo.getLabel() + "</input>";
				} else {
					str += ">" + vo.getLabel() + "</input>";
				}
			} else {
				str += ">" + vo.getLabel() + "</input>";
			}

		}

		TagUtils.getInstance().write(pageContext, str);

		return (EVAL_PAGE);
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

	public void release() {

		super.release();
		name = null;
		labelvalue = null;
		property = null;
		scope = null;
		onClick=null;

	}

	/**
	 * @return the onClick
	 */
	public String getOnClick() {
		return onClick;
	}

	/**
	 * @param onClick the onClick to set
	 */
	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}
}
