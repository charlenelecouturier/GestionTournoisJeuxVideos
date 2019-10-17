package com.action;

import com.user.User;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

private String confirmPassword;
private User userBean;

	public User getUserBean() {
		return userBean;
	}
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
	public void setUserBean(User user) {
		userBean = user;
	}
	public String execute() throws Exception {

	int var = User.register(this);
	if (var > 0) {
			return "SUCCESS";
	} else {
		addActionMessage("Inscription impossible, vérifiez la validité de l'e-mail.");

		return "input";
		}
	}
/**
	public void validate(){

		int var = 0;
		try {
			var = User.register(this);
			if (var > 0) {

			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}




		if ( userBean.getName().length() == 0 ){

			addFieldError( "userBean.name", "First name is required." );

		}


		if ( userBean.getEmail().length() == 0 ){

			addFieldError( "userBean.email", "Email is required." );

		}
		if ( userBean.getCity().length() == 0 ){

			addFieldError( "userBean.city", "City is required." );

		}
		if ( userBean.getPassword().length() == 0 ){

			addFieldError( "userBean.password", "Password is required." );

		}

		if ( userBean.getLastname().length() == 0 ){

			addFieldError( "userBean.lastname", "Last name is required." );

		}

		if ( userBean.getLastname().length() == 0 ){

			addFieldError( "userBean.birthdate", "Birth date is required." );

		}


	}**/


}
