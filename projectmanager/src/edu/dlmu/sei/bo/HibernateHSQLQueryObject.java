/*



 * Created on 2004-11-25



 *



 * TODO To change the template for this generated file go to



 * Window - Preferences - Java - Code Style - Code Templates



 */



package edu.dlmu.sei.bo;



import java.util.List;



import org.hibernate.Query;



import edu.dlmu.sei.bo.HibernateBusinessObject;



import edu.dlmu.sei.exception.RunException;



import edu.dlmu.sei.util.PageRange;



/**

 * @author stony.feng

 *

 */

public class HibernateHSQLQueryObject extends HibernateBusinessObject {



	private String hsql;



	private Query queryer;



	private PageRange pageRange = null;



	private List results;



	/**

	 * 

	 * @param clazz

	 * 

	 */



	public HibernateHSQLQueryObject() {



	}



	/**

	 * 

	 * @return Returns the pageRange.

	 * 

	 */



	public PageRange getPageRange() {



		return pageRange;



	}



	/**

	 * 

	 * @param pageRange

	 *            The pageRange to set.

	 * 

	 */



	public void setPageRange(PageRange pageRange) {



		this.pageRange = pageRange;



	}



	/**

	 * 

	 * @return Returns the queryer.

	 * 

	 */



	public Query getQueryer() {



		return queryer;



	}



	public String getHsql() {

		return hsql;

	}



	public void setHsql(String hsql) {

		this.hsql = hsql;

	}



	/**

	 * 

	 * @return Returns the results.

	 * 

	 */



	public List getResults() {



		return results;



	}



	protected void performBusinessLogic() throws RunException {



		try {



			Query queryer = getSession().createQuery(hsql);



			if (pageRange == null) {



				results = queryer.list();



			} else {



			}



		} catch (Exception e) {



			throw new RunException(e);



		}



	}



}

