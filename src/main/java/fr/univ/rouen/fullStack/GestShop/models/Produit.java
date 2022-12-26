package fr.univ.rouen.fullStack.GestShop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private  String nom;
    private  String description;
    @ManyToMany(fetch = FetchType.LAZY ,cascade = CascadeType.MERGE)
    @JoinTable(name = "produit_categorie", joinColumns
            = @JoinColumn(name = "produit_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id",
                    referencedColumnName = "id"))
    private List<Categorie> categorieList;
    private String imageUrl ;
    private double prix ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boutique_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Boutique boutique ;
    private  int quantité ;

    public Produit() {
    }

    public Produit(String nom, String description, List<Categorie> categorieList, String imageUrl, double prix, Boutique boutique, int quantité) {
        this.nom = nom;
        this.description = description;
        this.categorieList = categorieList;
        this.imageUrl = imageUrl;
        this.prix = prix;
        this.boutique = boutique;
        this.quantité = quantité;
    }
}
