package com.example.projecttp.Histoire;

import android.media.Image;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.io.Serializable;

public class Scène implements Serializable {

    String titre;
    int img;
    String Contenu;
    MediaStore.Audio son;

    public Scène(String titre, int img) {
        this.titre = titre;
        this.img = img;
    }

    public Scène(String titre, int img, String contenu) {
        this.titre=titre;
        this.img = img;
        Contenu = contenu;
    }

    public Scène(String titre,int img, String contenu, MediaStore.Audio son) {
        this.titre=titre;
        this.img = img;
        Contenu = contenu;
        this.son = son;
    }

    public String getTitre() {
        return titre;
    }

    public int getImg() {
        return img;
    }

    public String getContenu() {
        return Contenu;
    }

    public MediaStore.Audio getSon() {
        return son;
    }
}
