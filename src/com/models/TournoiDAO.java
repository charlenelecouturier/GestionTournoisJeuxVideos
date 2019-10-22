package com.models;

import com.javabeans.Tournoi;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;

public class TournoiDAO {

  private Tournoi tournoi;
  private ArrayList<Tournoi> listeTournoi = new ArrayList<>();
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

  public ArrayList<Tournoi> findAll(){

    Tournoi tournoi = null;
    try {
      Statement statement = this.connection.createStatement();
      ResultSet resultSet = statement.executeQuery(SQLConstant.SELECT_ALL_TOURNOIS);

      while(resultSet.next()){
        int idTournoi = resultSet.getInt("idTournoi");
        String format = resultSet.getString("format");
        String dateDeb = resultSet.getString("dateDeb");
        String nomJeu = resultSet.getString("nomJeu");
        float prix = resultSet.getFloat("prix");
        String places = resultSet.getString("places");

        System.out.println(idTournoi + " - " + format + " - " + dateDeb + " - " + nomJeu + " - " + prix + " - " + places);

        tournoi = new Tournoi(idTournoi, format, dateDeb, nomJeu, prix, places);

        this.listeTournoi.add(tournoi);
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return this.listeTournoi;
  }
}
