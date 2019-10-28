package com.action;


import com.models.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {

  private String password, email;
  private String msg;
  private UserDAO userDAO = null;
  Map<String,Object> session; //HashMap pour la session


	@Override
	public void setSession(Map<String,Object> pSession){
		this.session = pSession;
	}

	public String execute() throws Exception {

		userDAO = new UserDAO();

		msg = userDAO.getUser(email, password);
		if (msg.startsWith("Sorry")) {
			addActionMessage("Connexion failed. Wrong Password or Email.");
			return "input";
		} else {
			this.session = ActionContext.getContext().getSession(); //récupération de la session courante
			this.session.put("email", email);//ajout de l'email de l'utilisateur en variable de session
			this.session.put("password", password);//ajout du mot de passe de l'utilisateur en variable de session
		}
			if (userDAO.getUserType(email).equals("user")) {
				return "SUCCESSUSER";
			} 	else
				return "SUCCESSADMIN";
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
