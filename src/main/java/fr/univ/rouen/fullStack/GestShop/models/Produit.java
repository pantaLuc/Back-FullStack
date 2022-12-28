package fr.univ.rouen.fullStack.GestShop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private  String nom;
    private  String description;
    @ManyToMany(fetch = FetchType.LAZY)
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

   

    public Produit(String nom, String description, List<Categorie> categorieList, String imageUrl, double prix,
			Boutique boutique, int quantité) {
		this.nom = nom;
		this.description = description;
		this.categorieList = categorieList;
		this.imageUrl = imageUrl;
		this.prix = prix;
		this.boutique = boutique;
		this.quantité = quantité;
	}



	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @JsonIgnore
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
