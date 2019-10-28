package com.models;

import com.action.RechercheAction;
import com.javabeans.Tournoi;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class RechercheDAO {

    private static Connection connection;
    private Tournoi tournoi;
    private ArrayList<Tournoi> listeTournoi = new ArrayList<>();

    public RechercheDAO() {
        this.connection = ConnectionBDMysql.getInstance();
    }

    public ArrayList<Tournoi> getTournoi(String tournoi_name) {
        try {

            PreparedStatement statement = this.connection.prepareStatement(SQLConstant.SELECT_NOMJEU);
            statement.setString(1,tournoi_name);
            ResultSet str = statement.executeQuery();
            while (str.next()) {
                int idTournoi = str.getInt("idTournoi");
                String format = str.getString("format");
                String dateDeb = str.getString("dateDeb");
                String nomJeu = str.getString("nomJeu");
                float prix = str.getFloat("prix");
                String places = str.getString("places");
                tournoi = new Tournoi(idTournoi, format, dateDeb, nomJeu, prix, places);
                this.listeTournoi.add(tournoi);
            }
            str.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return this.listeTournoi;
    }

}
