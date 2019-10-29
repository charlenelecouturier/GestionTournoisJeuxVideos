package com.action;

import com.javabeans.User;
import com.models.ConnectionBDMysql;
import com.models.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class UpdatePasswordAction extends ActionSupport {
    private String password, email, newPassword;
    private String msg;
    UserDAO userDAO = new UserDAO();

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if (session.containsKey("email"))
            email = (String)session.get("email");

        if(password.equals(session.get("password"))) {
            userDAO.updatePassword(email, newPassword);
            session.remove("password");
            session.put("password", newPassword);
            return "SUCCESS";
        }
        else {
            addActionMessage("Wrong password.");
            return "input";
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


    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
