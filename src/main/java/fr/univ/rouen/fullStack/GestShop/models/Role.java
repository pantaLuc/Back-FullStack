package fr.univ.rouen.fullStack.GestShop.models;


import javax.persistence.*;

/*
Role doit pouvoir implementer GrantedAuthority
*/
@Entity
//public class Role  implements GrantedAuthority {
public class Role  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

   private String name ;

    private String description ;

    public Role() {
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*@Override
    public String getAuthority() {
        return name;
    }*/
}
