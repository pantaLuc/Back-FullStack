package fr.univ.rouen.fullStack.GestShop.dto;

import fr.univ.rouen.fullStack.GestShop.models.Boutique;
import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
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

    public ProduitDto(String nom, String description, List<Categorie> categorieList, String imageUrl, double prix, Boutique boutique, int quantité) {
        this.nom = nom;
        this.description = description;
        this.categorieList = categorieList;
        this.imageUrl = imageUrl;
        this.prix = prix;
        this.boutique = boutique;
        this.quantité = quantité;
    }


}
