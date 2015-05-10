package edu.dlmu.sei.struts.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.Constants;

import edu.dlmu.sei.util.PageRange;

public class PagesTag extends TagSupport {

	private String formname = Constants.BEAN_KEY;

	private String hrefs1 = "<a href=\"##\" onclick=\"javascript:$('jumpPage').value=";

	private String hrefs3 = "</a>\n";

	private String pageinput = "<input type=\"text\" name=\"pageinfo.currentPage\" id=\"jumpPage\" size=\"1\" class=\"inputline\" /> page\n";

	private String pageempty = "<div align=\"right\">(0-0/0 row) 0/0page</div>\n";

	private String showpage1 = "<script language=\"JavaScript\">\n";

	private String exceptionfuncmiddle = "try {\n";

	private String exceptionfuncmiddle4 = "prePageProcess();} catch (e) {\n";

	private String exceptionfuncmiddle6 = "}\n";

	private String showpage2 = " function gdc_showPage() {\n";

	private String showpage5 = "document.formpage.submit();";

	private String showpage6 = "	}\n";

	private String showpage7 = "</script>\n";

	private String getPageimg() {
		return (ajaxsubmit == "YES" ? "<img src=\"./images/i-go.gif\" onclick=\"gdc_ajax_page_show();\" style=\"cursor:hand\">\n"
				: "<img src=\"./images/i-go.gif\" onclick=\"gdc_showPage();\" style=\"cursor:hand\">\n");
	}

	private String getHrefs2() {
		return (ajaxsubmit == "YES" ? ";gdc_ajax_page_show();\">"
				: ";gdc_showPage();\">");
	}

	public int doEndTag() throws JspException {

		StringBuffer results = new StringBuffer("");

		try {

			String isDoSearch = (String) TagUtils.getInstance().lookup(
					pageContext, formname, "isDoSearch", "request");

			if (isDoSearch.equals("NO"))
				return (EVAL_PAGE);

			PageRange pageinfo = (PageRange) TagUtils.getInstance().lookup(
					pageContext, formname, "pageinfo", "request");

			String conditionStr = (String) TagUtils.getInstance().lookup(
					pageContext, formname, "conditionStr", "request");

			if (pageinfo.getHasResults()) {

				results.append("<div align=\"right\">\n");

				if (pageinfo.getHasPrevious()) {

					results.append(hrefs1 + "0" + getHrefs2() + "first"
							+ hrefs3);
					results.append(hrefs1 + pageinfo.getPreviousPage()
							+ getHrefs2() + "previous" + hrefs3);

				}

				if (pageinfo.getHasNext()) {

					results.append(hrefs1 + pageinfo.getNextPage()
							+ getHrefs2() + "next" + hrefs3);
					results.append(hrefs1 + "-1" + getHrefs2() + "last"
							+ hrefs3);

				}

				results.append(pageinput);

				results.append(getPageimg());

				results.append("(" + pageinfo.getFromRow() + "-"
						+ pageinfo.getToRow() + "/" + pageinfo.getTotalResult()
						+ "row)" + pageinfo.getCurrentPage() + "/"
						+ pageinfo.getTotalPage() + "page</div>\n");

				results
						.append("<input type=\"hidden\" name=\"conditionStr\" value='"
								+ conditionStr + "' /> ");

			} else {

				if ("YES".equals(isDoSearch))
					results.append(pageempty);

			}

			results.append(showpage1 + showpage2 + exceptionfuncmiddle
					+ exceptionfuncmiddle4 + exceptionfuncmiddle6 + showpage5
					+ showpage6 + showpage7);

			TagUtils.getInstance().write(pageContext, results.toString());

		} catch (JspException e) {

			TagUtils.getInstance().saveException(pageContext, e);

			throw e;

		}

		return (EVAL_PAGE);

	}

	private String ajaxsubmit = "NO";

	public void release() {

		super.release();

	}

	public String getAjaxsubmit() {
		return ajaxsubmit;
	}

	public void setAjaxsubmit(String ajaxsubmit) {
		this.ajaxsubmit = ajaxsubmit;
	}

}
