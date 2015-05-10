package edu.pm.base;

import edu.dlmu.sei.bo.HibernateQueryObject;
import java.util.Date;


public class PMBaseQuery extends HibernateQueryObject {

	public PMBaseQuery(Class clazz) {

		super(clazz);
	}
	
	public void setLIKE(String column, String data) {

		if (data == null || data.trim().equals(""))
			return;

		setLIKECondition(column, "%"+data.trim() + "%");

	}
	
	public void setRightLIKE(String column, String data) {

		if (data == null || data.trim().equals(""))
			return;

		setLIKECondition(column, data.trim() + "%");

	}

	public void setEQ(String column, Object data) {

		setEQCondition(column, data);

	}
	
	public void setNOEQ(String column, Object data) {

		setNOEQCondition(column, data);

	}
	
	public void setOrderBy(String column,String order) {
		if(order == null)
			return;
		if(order.equals("asc")){
			setASCOrder(column);
		}
		if(order.equals("desc")){
			setDESCOrder(column);
		}
		
	}

	public void setDateBetween(String property, Date dateBegin, Date dateEnd) {
		
		buildDateCondition(property, dateBegin, dateEnd);
	}
	
	public  Object loadByID(Class clazz,Long id,boolean lazyInit) {

		if (id == null)
			return null;

		PMBaseQuery queryer = new PMBaseQuery(clazz);
		
		queryer.setLazy(lazyInit);

		queryer.setEQ("id",id);
		
		queryer.execute();
		
		if (queryer.getResults().size() == 0)

			return null;

		return queryer.getResults().get(0);

	}
	
	



}

