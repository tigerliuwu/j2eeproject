
package edu.pm.uc.product.form;

import java.text.SimpleDateFormat;

import edu.dlmu.sei.util.CoreUtils;
import edu.pm.base.PMBaseForm;
import edu.pm.base.PMBaseQuery;
import edu.pm.vo.Products;
import edu.pm.vo.Targets;

/**
 * @author guo
 *
 */
public class ProductForm extends PMBaseForm {


 /** The composite primary key value. */
    private String id;
    
    private String targetId;

    /** The value of the targets association. */
    private String targetName;

    /** The value of the users association. */
    private String referById;

    /** The value of the users1 association. */
    private String auditById;

    /** The value of the simple productName property. */
    private java.lang.String productName;

    /** The value of the simple productSizePlan property. */
    private String productSizePlan;

    /** The value of the simple productSizeFact property. */
    private String productSizeFact;

    /** The value of the simple productUnit property. */
    private java.lang.String productUnit;

    /** The value of the simple referDate property. */
    private String referDate;

    /** The value of the simple status property. */
    private java.lang.String status;

    /** The value of the simple auditDate property. */
    private String auditDate;

    /** The value of the simple auditRemark property. */
    private java.lang.String auditRemark;
    


	public Products getVo() {
		
		Products vo = new Products();

		if (null != id && !"".equals(id)){
			vo.setId(new Long(id));
		}
		if (null != targetId && !"".equals(targetId)){
			PMBaseQuery targetQuery = new PMBaseQuery(Targets.class);
			Targets target=(Targets)targetQuery.loadByID(Targets.class,new Long(targetId),false);
			vo.setTargets(target);
		}
		if (null != referById && !"".equals(referById)){
			vo.setReferById(new Long(referById));
		}
		if (null != auditById && !"".equals(auditById)){
			vo.setAuditById(new Long(auditById));
		}
		if (null != productSizePlan && !"".equals(productSizePlan)){
			vo.setProductSizePlan(new Integer(productSizePlan));
		}
		if (null != productSizeFact && !"".equals(productSizeFact)){
			vo.setProductSizeFact(new Integer(productSizeFact));
		}
		if (null !=referDate && !referDate.trim().equals("")) {
			vo.setReferDate(CoreUtils.parseDate(referDate.trim()));
		}
		if (null !=auditDate && !auditDate.trim().equals("")) {
			vo.setAuditDate(CoreUtils.parseDate(auditDate.trim()));
		}
		
		vo.setProductName(this.getProductName());
		vo.setProductUnit(this.getProductUnit());
		vo.setStatus(this.getStatus());
		vo.setAuditRemark(this.getAuditRemark());
		
		return vo;
	}

	public void setVO(Products vo) {
		
		SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy-MM-dd");
		//java.text.DecimalFormat format = new java.text.DecimalFormat("#############0.00");
		
		if (null != vo.getId()){
			setId(vo.getId().toString());
		}
		if (null != vo.getTargets()){
			Targets target = vo.getTargets();
			setTargetId(target.getId().toString());
			setTargetName(target.getTargetName());
		}
		if (null != vo.getReferById()){
			setReferById(vo.getReferById().toString());
		}
		if (null != vo.getAuditById()){
			setAuditById(vo.getAuditById().toString());
		}
		if (null != vo.getProductSizePlan()){
			setProductSizePlan(vo.getProductSizePlan().toString());
		}
		if (null != vo.getProductSizeFact()){
			setProductSizeFact(vo.getProductSizeFact().toString());
		}
		if (null != vo.getReferDate()) {
			setReferDate(myFmt1.format(vo.getReferDate()));
		}
		if (null != vo.getAuditDate()) {
			setAuditDate(myFmt1.format(vo.getAuditDate()));
		}
		
		setProductName(vo.getProductName());
		setProductUnit(vo.getProductUnit());
		setStatus(vo.getStatus());
		setAuditRemark(vo.getAuditRemark());
		
	}

	public String getAuditById() {
		return auditById;
	}

	public void setAuditById(String auditById) {
		this.auditById = auditById;
	}

	public String getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}

	public java.lang.String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(java.lang.String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public java.lang.String getProductName() {
		return productName;
	}

	public void setProductName(java.lang.String productName) {
		this.productName = productName;
	}

	public String getProductSizeFact() {
		return productSizeFact;
	}

	public void setProductSizeFact(String productSizeFact) {
		this.productSizeFact = productSizeFact;
	}

	public String getProductSizePlan() {
		return productSizePlan;
	}

	public void setProductSizePlan(String productSizePlan) {
		this.productSizePlan = productSizePlan;
	}

	public java.lang.String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(java.lang.String productUnit) {
		this.productUnit = productUnit;
	}

	public String getReferById() {
		return referById;
	}

	public void setReferById(String referById) {
		this.referById = referById;
	}

	public String getReferDate() {
		return referDate;
	}

	public void setReferDate(String referDate) {
		this.referDate = referDate;
	}

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

}
