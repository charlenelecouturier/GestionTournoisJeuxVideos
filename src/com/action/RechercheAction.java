package com.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.javabeans.Tournoi;
import com.models.RechercheDAO;
import com.models.TournoiDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;

public class RechercheAction extends ActionSupport {

    private ArrayList<Tournoi> listeTournoi = null;
    RechercheDAO data = null;
    private String search,paramFormat, paramDate;
    private float paramPrix;

    public String execute(){
        HttpServletRequest req = ServletActionContext.getRequest();
        this.search= req.getParameter("search");
        data = new RechercheDAO();
        listeTournoi = data.getTournoi(this.search);
        return ActionSupport.SUCCESS;
    }

    public String rechercheAvance() throws ParseException, SQLException {
        HttpServletRequest req = ServletActionContext.getRequest();
        this.search= req.getParameter("search");
        this.paramDate = req.getParameter("paramDate");
        this.paramFormat = req.getParameter("paramFormat");
        if (req.getParameter("paramPrix").isEmpty()){
            this.paramPrix = -1;
        }else {
            this.paramPrix = Float.parseFloat(req.getParameter("paramPrix"));
        }
        data = new RechercheDAO();
        listeTournoi = data.getTournoiAvance(this.search,this.paramPrix,this.paramDate,this.paramFormat);
        return "success";
    }

    public ArrayList<Tournoi> getListeTournoi() {
        return listeTournoi;
    }

    public void setListeTournoi(ArrayList<Tournoi> rechercheListe) {
        this.listeTournoi = rechercheListe;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getParamFormat() {
        return paramFormat;
    }

    public void setParamFormat(String paramFormat) {
        this.paramFormat = paramFormat;
    }

    public float getParamPrix() {
        return paramPrix;
    }

    public void setParamPrix(float paramPrix) {
        this.paramPrix = paramPrix;
    }

    public String getParamDate() {
        return paramDate;
    }

    public void setParamDate(String paramDate) {
        this.paramDate = paramDate;
    }


}
