package com.models;

import com.action.RegisterAction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

public class UserDAO {

  private Connection connection;

  public UserDAO() {
    this.connection = ConnectionBDMysql.getInstance();
  }

  public /*static*/ int register(RegisterAction ra) throws Exception {

    int flag = 0;

    try {

      PreparedStatement ps = connection.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?)");
      ps.setString(1, ra.getUserBean().getName());
      ps.setString(2, ra.getUserBean().getLastname());
      ps.setString(3, ra.getUserBean().getEmail());

      ps.setString(4, ra.getUserBean().getPassword());

      ps.setString(5, ra.getUserBean().getBirthdate());

      ps.setString(6, ra.getUserBean().getCity());
      ps.setString(7, ra.getUserBean().getPhone());
      ps.setString(8, ra.getUserBean().getGender());

      flag = ps.executeUpdate();
      //connection.close();
      ps.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return flag;

  }

  public String getUser(String user_email, String user_pass) {
    try {

      CallableStatement cs = connection.prepareCall("{call getUser(?,?,?)}");
      cs.setString(1, user_email);
      cs.setString(2, user_pass);
      cs.registerOutParameter(3, Types.VARCHAR);
      cs.executeQuery();
      String str=cs.getString(3);
      //connection.close();
      cs.close();
      return str;
    } catch (Exception e) {
      return e.getMessage();
    }
  }

}
