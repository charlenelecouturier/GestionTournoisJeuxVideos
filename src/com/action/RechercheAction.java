package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;
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
    private String search;



    public String execute(){
            HttpServletRequest req = ServletActionContext.getRequest();
            this.search= req.getParameter("search");
            data = new RechercheDAO();
            listeTournoi = data.getTournoi(this.search);
            /* ===========DEBUG ===========
            Iterator<Tournoi> it = listeTournoi.iterator();
            Tournoi myTournoi;

            while(it.hasNext()){
                myTournoi = (Tournoi) it.next();
                System.out.println("Tournoi : " + myTournoi.getFormat() + " - " + myTournoi.getNomJeu());
            }     */
        return ActionSupport.SUCCESS;
    }
    public ArrayList<Tournoi> getListeTournoi() {
        return listeTournoi;
    }

    public void setListeTournoi(ArrayList<Tournoi> rechercheListe) {
        this.listeTournoi = rechercheListe;
    }


}
