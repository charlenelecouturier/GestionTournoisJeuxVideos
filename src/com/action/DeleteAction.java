package com.action;

import com.javabeans.User;
import com.models.ConnectionBDMysql;
import com.models.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class DeleteAction extends ActionSupport implements SessionAware{
    private String password, email;
    private String msg;
    UserDAO userDAO = new UserDAO();
    Map<String,Object> session; //HashMap pour la session


    @Override
    public void setSession(Map<String,Object> pSession){
        this.session = pSession;
    }

    public String execute() throws Exception {
        //msg = userDAO.getUser(email, password);

        if (session.containsKey("email"))
            email = (String)session.get("email");

        if(password.equals(session.get("password"))) {
            userDAO.delete(email);
            session.remove("email",email);
            session.remove("password",password);
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

}
