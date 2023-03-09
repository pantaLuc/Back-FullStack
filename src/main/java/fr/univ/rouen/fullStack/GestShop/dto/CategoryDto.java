package fr.univ.rouen.fullStack.GestShop.dto;

public class CategoryDto {
    private  String nom ;
    private String description ;

    public String getNom() {
        return nom;
    }

    public CategoryDto() {
    }

    public CategoryDto(String nom, String description) {
        this.nom = nom;
        this.description = description;
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
