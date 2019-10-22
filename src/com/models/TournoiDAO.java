package com.models;

import com.javabeans.Tournoi;

import java.sql.*;
import java.sql.Date;

public class TournoiDAO {

  private Tournoi tournoi;
  private Connection connection;

  public TournoiDAO() {
    this.connection = ConnectionBDMysql.getInstance();
  }

  public boolean create(Tournoi tournoi){

    this.tournoi = tournoi;
    this.tournoi.setPlaces("Disponible");

    //Insertion dans la BD
    PreparedStatement statement = null;
    try {
      statement = connection.prepareStatement(SQLConstant.INSERT_TOURNOI);
      //Insert parameter at the location of the question mark in the SQL Query
      // statement.setString(1, "DEFAULT");
      statement.setString(1, tournoi.getFormat());
      statement.setDate(2, Date.valueOf(tournoi.getDateDeb()));
      statement.setString(3, tournoi.getNomJeu());
      statement.setFloat(4, tournoi.getPrix());
      statement.setString(5, tournoi.getPlaces());

      //Executing the preparedStatement
      statement.executeUpdate();
      statement.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return true;
  }
}
