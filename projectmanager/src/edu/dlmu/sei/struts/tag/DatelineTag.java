package edu.dlmu.sei.struts.tag;

import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.html.TextTag;
import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;

public class DatelineTag extends TextTag {

	protected String defaultStyle = "inputline";

	protected String defaulteDP = "null";

	protected String defaultdmin = "0";

	public int doEndTag() throws JspException {

		StringBuffer results = new StringBuffer("");

		try {

			results
					.append("<img src=\"images/i-c.gif\" style=\"cursor:hand\" onClick=\"ShowCalendar("
							+ getStyleId()
							+ ","
							+ getStyleId()
							+ ","
							+ defaulteDP + "," + defaultdmin + ");\">\n");

			ResponseUtils.write(pageContext, results.toString());

		} catch (JspException e) {

			RequestUtils.saveException(pageContext, e);

			throw e;

		}

		return (EVAL_PAGE);

	}

}
