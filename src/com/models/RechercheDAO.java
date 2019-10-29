package com.models;

import com.action.RechercheAction;
import com.javabeans.Tournoi;

import java.sql.*;
import java.util.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechercheDAO {

    private static Connection connection;
    private Tournoi tournoi;
    private ArrayList<Tournoi> listeTournoi = new ArrayList<>();
    String tag;

    public RechercheDAO() {
        this.connection = ConnectionBDMysql.getInstance();
    }

    public ArrayList<Tournoi> getTournoi(String tournoi_name) {
        try {
            PreparedStatement statement;
            if( tournoi_name.isEmpty()){
                statement = this.connection.prepareStatement(SQLConstant.SELECT_ALL_TOURNOIS);
            }else{
                statement = this.connection.prepareStatement(SQLConstant.SELECT_NOMJEU);
                statement.setString(1,tournoi_name);
            }

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

    public ArrayList<Tournoi> getTournoiAvance(String tournoi_name, Float paramPrix, String paramDate, String paramFormat) throws SQLException {

        Map<Integer, String> statementParams = new HashMap<>();
        Map<Integer, Float> statementFloat = new HashMap<>();

        PreparedStatement statement;
        String query = "SELECT * From Tournoi";
        boolean firstCondition = true;
        int i = 1;

        if (!tournoi_name.isEmpty()) {
            if (firstCondition) {
                query += " where ";
                firstCondition = false;
            } else {
                query += " and ";
            }
            query += "nomJeu = ?";
            statementParams.put(i, tournoi_name);
            i++;
        }
        if(!paramDate.equals("")){
            if (firstCondition) {
                query += " where ";
                firstCondition = false;
            } else {
                query += " and ";
            }
            query += "dateDeb = ?";
            statementParams.put(i, paramDate);
            i++;

        }
        if(paramPrix != -1){
            if (firstCondition) {
                query += " where ";
                firstCondition = false;
            } else {
                query += " and ";
            }
            query += "prix = ?";
            statementFloat.put(i, paramPrix);
            i++;
        }
        if(!paramFormat.equals("")){
            if (firstCondition) {
                query += " where ";
                firstCondition = false;
            } else {
                query += " and ";
            }
            query += "format = ?";
            statementParams.put(i, paramFormat);
            i++;
        }
        query+=";";
        statement = connection.prepareStatement(query);
        System.out.println(statementParams);
        for (Map.Entry<Integer, String> entry : statementParams.entrySet()) {
            statement.setString(entry.getKey(), (String) entry.getValue());
        }
        for (Map.Entry<Integer, Float> entry : statementFloat.entrySet()) {
            statement.setFloat(entry.getKey(), entry.getValue());
        }
        System.out.println(query);

        ResultSet str = statement.executeQuery();
        System.out.println(statement);

        while (str.next()) {
            int idTournoi = str.getInt("idTournoi");
            String format = str.getString("format");
            String dateDeb = str.getString("dateDeb");
            String nomJeu = str.getString("nomJeu");
            float prix = str.getFloat("prix");
            String places = str.getString("places");
            tournoi = new Tournoi(idTournoi, format, dateDeb, nomJeu, prix, places);
            System.out.println(idTournoi + " - " + format + " - " + dateDeb + " - " + nomJeu + " - " + prix + " - " + places);

            this.listeTournoi.add(tournoi);
        }
        str.close();
        return this.listeTournoi;
    }

}
