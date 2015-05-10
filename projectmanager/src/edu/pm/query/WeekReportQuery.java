/*

 * Created on 2004-11-11

 *

 * TODO To change the template for this generated file go to

 * Window - Preferences - Java - Code Style - Code Templates

 */

package edu.pm.query;

import java.util.Iterator;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import edu.pm.base.PMBaseQuery;
import edu.pm.vo.WeekReports;

public class WeekReportQuery extends PMBaseQuery {

	public WeekReportQuery(Class clazz) {

		super(clazz);
		
		//addInnerJoin(1, "impCertificateBatteryLines", "impCertificateBatteryLines");
		
		//addInnerJoin(2, "item", "impCertificateBatteryLines.item", 1);

	}
	
	protected void lazeInit() throws HibernateException {

		super.lazeInit();

		Iterator it = getResults().iterator();

		while (it.hasNext()) {
			WeekReports weekReport = (WeekReports) it.next();
			Hibernate.initialize(weekReport.getTargets());
			Hibernate.initialize(weekReport.getWeeks());
			
		}

	}

}
