/*
 * Created on 2006-9-15
 *
 * Organization: BearingPoint Inc.
 */
package edu.pm.uc.product.form;

import edu.dlmu.sei.struts.form.SearchCondition;


public class ProductCondition extends SearchCondition {

		
	    /** The value of the simple status property. */
	    private java.lang.String status;
	    
	    private java.lang.String referById;

		public java.lang.String getStatus() {
			return status;
		}

		public void setStatus(java.lang.String status) {
			this.status = status;
		}

		public java.lang.String getReferById() {
			return referById;
		}

		public void setReferById(java.lang.String referById) {
			this.referById = referById;
		}

	  
}

