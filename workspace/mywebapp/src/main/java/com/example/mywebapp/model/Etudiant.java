package com.example.mywebapp.model;


public class Etudiant {

    private Long id;

    private String nom;
    private String prenom;

    private boolean L1;
    private boolean L2;
    private boolean L3;

    // Constructeurs
    public Etudiant() {}

    public Etudiant(String nom, String prenom, boolean L1, boolean L2, boolean L3) {
        this.nom = nom;
        this.prenom = prenom;
        this.L1 = L1;
        this.L2 = L2;
        this.L3 = L3;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isL1() {
        return L1;
    }

    public void setL1(boolean L1) {
        this.L1 = L1;
    }

    public boolean isL2() {
        return L2;
    }

    public void setL2(boolean L2) {
        this.L2 = L2;
    }

    public boolean isL3() {
        return L3;
    }

    public void setL3(boolean L3) {
        this.L3 = L3;
    }
}