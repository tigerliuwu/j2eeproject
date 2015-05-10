/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.product.form;

import java.io.Serializable;

import edu.dlmu.sei.struts.form.BaseSearchForm;



/**
 * This class is used for the searching certificate battery function.
 *
 * @author jichun.guo
 * @version v1.0
 * 
 */
public class ProductSearchForm extends BaseSearchForm implements

		Serializable {


	protected void initConditionPre() {

		setCondition(new ProductCondition());

	}



}

