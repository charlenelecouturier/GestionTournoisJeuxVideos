package com.action;

import com.opensymphony.xwork2.ActionSupport;

import com.javabeans.Tournoi;
import com.models.TournoiDAO;

public class TournoiAction extends ActionSupport {

  // ========= Attributs =========

  private TournoiDAO tournoiDAO = null;
  private Tournoi tournoi;

  // ========= Getters/Setters =========

  public Tournoi getTournoi() {
    return tournoi;
  }

  public void setTournoi(Tournoi tournoi) {
    this.tournoi = tournoi;
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
}
