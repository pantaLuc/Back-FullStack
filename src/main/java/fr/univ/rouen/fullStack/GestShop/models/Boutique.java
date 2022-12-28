package fr.univ.rouen.fullStack.GestShop.models;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

@Entity
public class Boutique {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    private String nom ;
    private LocalDateTime dateCreationBoutique ;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "list_horaire", joinColumns
			= @JoinColumn(name = "boutique_id",
			referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "horaire_id",
					referencedColumnName = "id"))
    private List<Horaire> horaireList ;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	Utilisateur utilisateur ;

	public Boutique() {
	}
	public Boutique(String nom, LocalDateTime dateCreationBoutique, Horaire horaireList ,Utilisateur utilisateur) {
		this.nom = nom;
		this.dateCreationBoutique = dateCreationBoutique;
		this.horaireList = Arrays.asList(horaireList);
		this.utilisateur=utilisateur ;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDateTime getDateCreationBoutique() {
		return dateCreationBoutique;
	}

	public void setDateCreationBoutique(LocalDateTime dateCreationBoutique) {
		this.dateCreationBoutique = dateCreationBoutique;
	}

	public List<Horaire> getHoraireList() {
		return horaireList;
	}

	public void setHoraireList(List<Horaire> horaireList) {
		this.horaireList = horaireList;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
