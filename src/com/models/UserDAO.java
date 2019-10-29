package com.models;

import com.action.RegisterAction;
import com.javabeans.User;

import java.awt.event.PaintEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

  private Connection connection;

  public UserDAO() {
    this.connection = ConnectionBDMysql.getInstance();
  }

  public /*static*/ int register(RegisterAction ra) throws Exception {

    int flag = 0;

    try {

      PreparedStatement ps = connection.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?,?)");
      ps.setString(1, ra.getUserBean().getName());
      ps.setString(2, ra.getUserBean().getLastname());
      ps.setString(3, ra.getUserBean().getEmail());

      ps.setString(4, ra.getUserBean().getPassword());

      ps.setString(5, ra.getUserBean().getBirthdate());

      ps.setString(6, ra.getUserBean().getCity());
      ps.setString(7, ra.getUserBean().getPhone());
      ps.setString(8, ra.getUserBean().getGender());
      ps.setString(9, ra.getUserBean().getUsertype()); //ajout du type de user (admin ou user)

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

  public boolean delete(String userEmail){
    PreparedStatement statement = null;
    try {
      statement = connection.prepareStatement(SQLConstant.DELETE_USER);

      statement.setString(1, userEmail);

      statement.executeUpdate();
      statement.close();

    } catch (SQLException e) {
      Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
    }
    return true;
  }

  public boolean updatePassword(String userEmail, String userPassword){
    PreparedStatement statement = null;
    try{
      statement = connection.prepareStatement(SQLConstant.UPDATE_PASSWORD);

      statement.setString(1, userPassword);
      statement.setString(2, userEmail);

      statement.executeUpdate();
      statement.close();
    }
    catch (SQLException e) {
      Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
    }
    return true;

  }

  //pour avoir le type du user dans la table users (admin ou user)
  public String getUserType(String userEmail) {
    String uValueType = null;
    try {
      PreparedStatement statement= connection.prepareStatement(SQLConstant.SELECT_USERTYPE);

      statement.setString(1, userEmail);
      ResultSet resultSet = statement.executeQuery();
      while(resultSet.next()) {

        uValueType = resultSet.getString("USERTYPE");
      }
      statement.close();
      resultSet.close();

    } catch (SQLException e) {
      Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
    }
    return uValueType;
  }


}
