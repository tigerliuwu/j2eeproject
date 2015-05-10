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
import edu.pm.vo.Products;

public class ProductQuery extends PMBaseQuery {

	public ProductQuery(Class clazz) {

		super(clazz);
		
		//addInnerJoin(1, "impCertificateBatteryLines", "impCertificateBatteryLines");
		
		//addInnerJoin(2, "item", "impCertificateBatteryLines.item", 1);

	}
	
	protected void lazeInit() throws HibernateException {

		super.lazeInit();

		Iterator it = getResults().iterator();

		while (it.hasNext()) {
			Products product = (Products) it.next();
			Hibernate.initialize(product.getTargets());
			
		}

	}
	
	public  Object loadByID(Class clazz,Long id,boolean lazyInit) {

		if (id == null)
			return null;

		ProductQuery queryer = new ProductQuery(clazz);
		
		queryer.setLazy(lazyInit);

		queryer.setEQ("id",id);
		
		queryer.execute();
		
		if (queryer.getResults().size() == 0)

			return null;

		return queryer.getResults().get(0);

	}

}
