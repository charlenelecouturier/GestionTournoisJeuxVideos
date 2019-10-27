package com.action;

import com.javabeans.User;
import com.models.ConnectionBDMysql;
import com.models.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {
    private String password, email;
    private String msg;
    UserDAO userDAO = new UserDAO();

    public String execute() throws Exception {
        msg = userDAO.getUser(email, password);

        if (msg.startsWith("Sorry")) {
            addActionMessage("Wrong password.");

            return "input";
        }
        else {
            try {
                userDAO.delete(email);
            }
            catch (Exception e){
                e.printStackTrace();
            }
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
