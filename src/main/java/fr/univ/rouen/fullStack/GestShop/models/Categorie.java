package fr.univ.rouen.fullStack.GestShop.models;

import javax.persistence.*;


@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private  long id ;
    @Column(name = "nom_categorie" , nullable = false)
    private String  nom ;
    @Column(name = "categorie_description")
   private  String description ;

    public Categorie() {
    }

    public Categorie(String nom, String description) {
        this.nom = nom;
        this.description = description;
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
}
