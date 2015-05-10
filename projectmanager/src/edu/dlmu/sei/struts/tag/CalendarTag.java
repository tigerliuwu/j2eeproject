package edu.dlmu.sei.struts.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;

public class CalendarTag extends BodyTagSupport {

	protected String contextpath = null;

	protected String defaultcontextpath = "/ols";

	public String getContextpath() {
		return contextpath;
	}

	public void setContextpath(String contextpath) {
		this.contextpath = contextpath;
	}

	public int doStartTag() throws JspException {

		return (EVAL_BODY_BUFFERED);

	}

	public int doAfterBody() throws JspException {

		return (SKIP_BODY);

	}

	public int doEndTag() throws JspException {

		if (contextpath == null)

			contextpath = defaultcontextpath;

		StringBuffer results = new StringBuffer("");

		try {

			results.append("<script language=\"javascript\" src=\""
					+ contextpath + "/js/calendar/date.js\"></script>\n");

			results
					.append("<p><iframe id=\"CalFrame\" style=\"display: none; z-index: 100; width: 148; position: absolute; height: 194; left: 658px; top: 240px\" marginWidth=\"0\" marginHeight=\"0\" src=\""
							+ contextpath
							+ "/js/calendar/calendar.htm\" frameBorder=\"0\" noResize	scrolling=\"no\"></iframe></p>\n");

			ResponseUtils.write(pageContext, results.toString());

		} catch (JspException e) {

			RequestUtils.saveException(pageContext, e);

			throw e;

		}

		return (EVAL_PAGE);

	}

	public void release() {

		super.release();

		this.contextpath = null;

	}

}
