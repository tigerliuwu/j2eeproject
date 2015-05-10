package edu.dlmu.sei.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionMapping;

import edu.dlmu.sei.util.CoreUtils;
import edu.dlmu.sei.util.PageRange;

public class BaseSearchForm extends BaseActionForm {

	private String isReturn = "YES";

	private String isDoSearch = "NO";

	private boolean sessionaction = true;

	private String sessionname = "condition";

	private String conditionStr = "";

	private SearchCondition condition;

	private PageRange pageinfo = new PageRange();

	public BaseSearchForm() {
		super();
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		super.reset(mapping, request);

		initConditionPre();

	}

	protected  void initConditionPre(){
		setCondition(new SearchCondition());
	}

	public void initConditionPost() {

		this.setIsDoSearch("YES");

		if (StringUtils.isNotBlank(this.getConditionStr())) {

			this.setCondition((SearchCondition) CoreUtils.decode64(this
					.getConditionStr()));

			this.condition.setCurrentpage(pageinfo.getCurrentPage());

		} else {

			if (sessionaction) {

				if ("YES".equals(getIsReturn())) {

					Object obj1 = request.getSession()
							.getAttribute(sessionname);

					if (obj1 != null) {

						Object obj2 = CoreUtils.decode64((String) obj1);

						if (obj2.getClass().equals(
								this.getCondition().getClass())) {

							this.setCondition((SearchCondition) obj2);

							pageinfo.setCurrentPage(condition.getCurrentpage());

						}
					}
				}
			}

		}

		this.setConditionStr(CoreUtils.encode64(this.getCondition()));

		request.setAttribute("pageinfo", pageinfo);

		if (sessionaction)
			request.getSession().setAttribute(sessionname, conditionStr);

	}

	public String getIsDoSearch() {

		return isDoSearch;
	}

	public void setIsDoSearch(String isDoSearch) {
		this.isDoSearch = isDoSearch;
	}

	public String getConditionStr() {
		return conditionStr;
	}

	public void setConditionStr(String conditionStr) {
		this.conditionStr = conditionStr;
	}

	public SearchCondition getCondition() {
		return condition;
	}

	public void setCondition(SearchCondition condition) {
		this.condition = condition;
	}

	public PageRange getPageinfo() {
		return pageinfo;
	}

	public void setPageinfo(PageRange pageinfo) {
		this.pageinfo = pageinfo;
	}

	public String getIsReturn() {
		return isReturn;
	}

	public void setIsReturn(String isReturn) {
		this.isReturn = isReturn;
	}

	public void setSessionaction(boolean sessionaction) {
		this.sessionaction = sessionaction;
	}

	public void setSessionname(String sessionname) {
		this.sessionname = sessionname;
	}

}