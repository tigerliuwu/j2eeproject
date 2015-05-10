package edu.pm.base;



import edu.dlmu.sei.bo.HibernateBusinessObject;

import edu.dlmu.sei.dao.HibernateDataAccessObject;

import edu.pm.vo.Users;



public class PMBaseDAO extends HibernateDataAccessObject {


	protected Users getEmployee() {

		return (Users) HibernateBusinessObject.USER.get();

	}



	public PMBaseDAO(Class clazz) {

		super(clazz);

	}



	public Long getId() {

		return (Long) id;

	}
	
	///////////////////////////////////////////////////////////////////

	protected void onDeleteTrigger(Object object) {

		super.onDeleteTrigger(object);

	}

	protected void onSaveOrUpdateTrigger(Object object) {

		super.onSaveOrUpdateTrigger(object);

	}

	protected void onSaveTrigger(Object object) {

		super.onSaveTrigger(object);

	}

	protected void onUpdateTrigger(Object object) {

		super.onUpdateTrigger(object);

	}
	
	 protected void onTriggerBeforeSave(Object object) {


	        super.onTriggerBeforeSave(object);

	        //PubWarning vo = (PubWarning) object;

	        //vo.setSubmitedById(getEmployee().getEmployeeid());

	        //vo.setSubmitedTime(new Date());

	  }

	  protected void onTriggerBeforeUpdate(Object object) {

	        super.onTriggerBeforeUpdate(object);

	       /* PubWarning vo = (PubWarning) object;

	        vo.setLastUpdateBy(getEmployee().getEmployeeid());

	        vo.setLastUpdateDate(new Date());*/

	  }
	////////////////////////////////////////////////////////////////////



}

