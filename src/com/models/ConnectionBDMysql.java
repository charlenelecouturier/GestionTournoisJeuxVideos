package com.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionBDMysql {

  private static String driverClass = ConnectionProperties.DRIVERCLASS;
  private static String url = ConnectionProperties.URL;
  private static String user = ConnectionProperties.USER;
  private static String pwd = ConnectionProperties.PWD;

  private static Connection connection;

  private ConnectionBDMysql() {
    try {
      Class.forName(driverClass);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    try {
      connection = DriverManager.getConnection(url, user, pwd);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Une erreur de connexion");
    }
  }

  public static Connection getInstance(){
    if(connection == null){
      new ConnectionBDMysql();
    }
    return connection;
  }

  /*
  public static void main(String[] args) {
    System.out.println("Hello, World !!!");
    ConnectionBDMysql.getInstance();
  }
   */

}
