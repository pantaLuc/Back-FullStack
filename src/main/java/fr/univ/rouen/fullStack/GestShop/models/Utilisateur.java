package fr.univ.rouen.fullStack.GestShop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    @Column(name="username")
    private String username ;
    private String  password ;
    private String firstName ;
    private String lastName ;
   /* je donne a un utilisateur plusieur roles du genre il peut etre livreur-vendeur */
   @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns
            = @JoinColumn(name = "user_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "id"))
    private List<Role> roles;

    public Utilisateur() {
    }

    public Utilisateur(String username, String password, String firstName, String lastName, Role roles ) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = Arrays.asList(roles);

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


}
