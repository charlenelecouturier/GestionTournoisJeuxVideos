package com.javabeans;

import java.sql.Date;

public class Tournoi {

  private Integer id;
  private String format;
  private String dateDeb;
  //private Date dateDeb;
  private String nomJeu;
  private float prix;
  private String places;

  public Tournoi() {
  }

  public Tournoi(Integer id, String format, String dateDeb, String nomJeu, float prix, String places) {
    this.id = id;
    this.format = format;
    this.dateDeb = dateDeb;
    this.nomJeu = nomJeu;
    this.prix = prix;
    this.places = places;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String getFormat() {
    return format;
  }

  public void setDateDeb(String dateDeb) {
    this.dateDeb = dateDeb;
  }

  public String getDateDeb() {
    return dateDeb;
  }

  public void setNomJeu(String nomJeu) {
    this.nomJeu = nomJeu;
  }

  public String getNomJeu() {
    return nomJeu;
  }

  public void setPrix(float prix) {
    this.prix = prix;
  }

  public float getPrix() {
    return prix;
  }

  public void setPlaces(String places) {
    this.places = places;
  }

  public String getPlaces() {
    return places;
  }

}
