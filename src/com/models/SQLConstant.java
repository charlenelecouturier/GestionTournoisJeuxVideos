package com.models;

public class SQLConstant {

  protected static final String SELECT_ALL_TOURNOIS = "SELECT * FROM tournoi";

  protected static final String INSERT_TOURNOI = "INSERT INTO tournoi(idTournoi, format, dateDeb, nomJeu, prix, places) VALUES (DEFAULT,?,?,?,?,?)";

  protected static final String DELETE_USER = "DELETE FROM users WHERE email = ?";

  protected static final String SELECT_NOMJEU = "select * from Tournoi where Tournoi.nomJeu= ?";

  protected static final String SELECT_USERTYPE = "select USERTYPE from users where EMAIL = ?";

}
