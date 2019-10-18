package com.action;

import com.models.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

  private String password, email;
  private String msg;
	private UserDAO userDAO = null;

	public String execute() throws Exception {

	  userDAO = new UserDAO();

	  msg = userDAO.getUser(email, password);
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
