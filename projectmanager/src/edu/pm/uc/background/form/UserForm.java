
package edu.pm.uc.background.form;

import edu.pm.base.PMBaseForm;
import edu.pm.vo.Users;

/**
 * @author guo
 *
 */
public class UserForm extends PMBaseForm {
	
 /** The composite primary key value. */
    private java.lang.String id;

    /** The value of the simple loginName property. */
    private java.lang.String loginName;

    /** The value of the simple password property. */
    private java.lang.String password;

    /** The value of the simple userName property. */
    private java.lang.String userName;

    /** The value of the simple sex property. */
    private java.lang.String sex;

    /** The value of the simple email property. */
    private java.lang.String email;

    /** The value of the simple address property. */
    private java.lang.String address;

    /** The value of the simple phone property. */
    private java.lang.String phone;

    /** The value of the simple handset property. */
    private java.lang.String handset;

    /** The value of the simple isDeleted property. */
    private java.lang.String isDeleted;
    
    private java.lang.String isAdmin;
		
		public Users getVo() {
			
			Users vo = new Users();

			if (null != id && !"".equals(id)){
				vo.setId(new Long(id));
			}
			vo.setLoginName(this.getLoginName());
			vo.setAddress(this.getAddress());
			vo.setEmail(this.getEmail());
			vo.setHandset(this.getHandset());
			vo.setIsAdmin(this.getIsAdmin());
			vo.setIsDeleted(this.getIsDeleted());
			vo.setPassword(this.getPassword());
			vo.setPhone(this.getPhone());
			vo.setSex(this.getSex());
			vo.setUserName(this.getUserName());
			
			
			return vo;
		}

		public void setVO(Users vo) {
			
			
			if (null != vo.getId()){
				setId(vo.getId().toString());
			}
			
			setLoginName(vo.getLoginName());
			setAddress(vo.getAddress());
			setEmail(vo.getEmail());
			setHandset(vo.getHandset());
			setIsAdmin(vo.getIsAdmin());
			setIsDeleted(vo.getIsDeleted());
			setPassword(vo.getPassword());
			setPhone(vo.getPhone());
			setSex(vo.getSex());
			setUserName(vo.getUserName());
			
		}

		public java.lang.String getAddress() {
			return address;
		}

		public void setAddress(java.lang.String address) {
			this.address = address;
		}

		public java.lang.String getEmail() {
			return email;
		}

		public void setEmail(java.lang.String email) {
			this.email = email;
		}

		public java.lang.String getHandset() {
			return handset;
		}

		public void setHandset(java.lang.String handset) {
			this.handset = handset;
		}

		public java.lang.String getId() {
			return id;
		}

		public void setId(java.lang.String id) {
			this.id = id;
		}

		public java.lang.String getIsAdmin() {
			return isAdmin;
		}

		public void setIsAdmin(java.lang.String isAdmin) {
			this.isAdmin = isAdmin;
		}

		public java.lang.String getIsDeleted() {
			return isDeleted;
		}

		public void setIsDeleted(java.lang.String isDeleted) {
			this.isDeleted = isDeleted;
		}

		public java.lang.String getLoginName() {
			return loginName;
		}

		public void setLoginName(java.lang.String loginName) {
			this.loginName = loginName;
		}

		public java.lang.String getPassword() {
			return password;
		}

		public void setPassword(java.lang.String password) {
			this.password = password;
		}

		public java.lang.String getPhone() {
			return phone;
		}

		public void setPhone(java.lang.String phone) {
			this.phone = phone;
		}

		public java.lang.String getSex() {
			return sex;
		}

		public void setSex(java.lang.String sex) {
			this.sex = sex;
		}

		public java.lang.String getUserName() {
			return userName;
		}

		public void setUserName(java.lang.String userName) {
			this.userName = userName;
		}

}
