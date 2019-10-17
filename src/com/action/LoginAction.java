package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.user.User;

public class LoginAction extends ActionSupport {

private String password, email;
	private String msg;
	User adm = new User();


	public String execute() throws Exception {
		msg = adm.getUser(email, password);
		if (msg.startsWith("Sorry")) {
			addActionMessage("Connexion failed. Wrong Password or Email.");

			return "input";
		} else {
			return "SUCCESS";
		}
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
