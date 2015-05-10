package edu.pm.uc.login.form;



import edu.pm.base.PMBaseForm;



public class LoginForm extends PMBaseForm {
	
		
	String username;
	
	String password;
	
	String userlocale;
	
	String rand;



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserlocale() {
		return userlocale;
	}

	public void setUserlocale(String userlocale) {
		this.userlocale = userlocale;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}
	
	



}

