package edu.pm.base;



import edu.dlmu.sei.bo.HibernateBusinessObject;

import edu.pm.vo.Users;



public abstract class PMBaseBusinessObject extends HibernateBusinessObject {


	public Users getEmployee() {

		return (Users) USER.get();

	}



}

