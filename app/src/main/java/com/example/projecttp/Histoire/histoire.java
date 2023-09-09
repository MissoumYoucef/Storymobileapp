package com.example.projecttp.Histoire;

import java.util.ArrayList;

public class histoire {
    String titre;
    int img;
    boolean isFavorite;
    ArrayList<Scène> lesScènes;

    public histoire(String titre,int img) {
        this.isFavorite=false;
        this.titre = titre;
        this.img = img;
    }

    public histoire(String titre,int img, ArrayList<Scène> lesScènes) {
        this.isFavorite=false;
        this.titre = titre;
        this.img = img;
        this.lesScènes = lesScènes;
    }
    public histoire(String titre,int img,boolean isFavorite, ArrayList<Scène> lesScènes) {
        this.isFavorite=isFavorite;
        this.titre = titre;
        this.img = img;
        this.lesScènes = lesScènes;
    }
    public String getTitre() {
        return titre;
    }
    public ArrayList<Scène> getLesScènes() {
        return lesScènes;
    }

    public int getImg() {
        return img;
    }

    public boolean isFavorite() { return isFavorite; }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
