package fr.univ.rouen.fullStack.GestShop.dto;

import fr.univ.rouen.fullStack.GestShop.models.Boutique;
import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class ProduitDto {
    private  String nom;
    private  String description;

    private List<Categorie> categorieList;
    private String imageUrl ;
    private double prix ;

    private Boutique boutique ;
    private  int quantité ;

    public ProduitDto() {
    }

    public ProduitDto(String nom, String description, Categorie categorieList, String imageUrl, double prix, Boutique boutique, int quantité) {
        this.nom = nom;
        this.description = description;
        this.categorieList = Arrays.asList(categorieList);
        this.imageUrl = imageUrl;
        this.prix = prix;
        this.boutique = boutique;
        this.quantité = quantité;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Categorie> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Categorie> categorieList) {
        this.categorieList = categorieList;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Boutique getBoutique() {
        return boutique;
    }

    public void setBoutique(Boutique boutique) {
        this.boutique = boutique;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }
}
