package com.action;

import com.opensymphony.xwork2.ActionSupport;

import com.javabeans.Tournoi;
import com.models.TournoiDAO;
import java.util.Iterator;
import java.util.List;

public class TournoiAction extends ActionSupport {

  // ========= Attributs =========

  private TournoiDAO tournoiDAO = null;
  private Tournoi tournoi;
  private List<Tournoi> listeTournoi = null;

  // ========= Getters/Setters =========

  public Tournoi getTournoi() {
    return tournoi;
  }
  public void setTournoi(Tournoi tournoi) {
    this.tournoi = tournoi;
  }
  public List<Tournoi> getListeTournoi() { return listeTournoi; }
  public void setListeTournoi(List<Tournoi> listeTournoi) {
    this.listeTournoi = listeTournoi;
  }

  // ========= Méthodes =========

  public String enregistrerTournoi(){

    // Si (this.tournoi == null) c'est que l'on entre dans l'ajout du tournoi
    // Sinon, c'est que l'on vient de valider le formulaire d'ajout

    // Par défaut, le résultat est "input"
    String vResult = ActionSupport.INPUT;

    // Validation de l'ajout du tournoi (tournoi != null)
    if(this.tournoi != null){
      // TODO

      tournoiDAO = new TournoiDAO();
      tournoiDAO.create(tournoi);

      // Si ajout avec succés -> Resultat "success"
      vResult = ActionSupport.SUCCESS;
    }

    return vResult;
  }

  public String execute(){

    tournoiDAO = new TournoiDAO();
    listeTournoi = tournoiDAO.findAll();

    Iterator<Tournoi> it = listeTournoi.iterator();
    Tournoi myTournoi;

    while(it.hasNext()){
      myTournoi = (Tournoi) it.next();
      System.out.println("Tournoi : " + myTournoi.getFormat() + " - " + myTournoi.getNomJeu());
    }

    return ActionSupport.INPUT;
  }

}
