package fr.univ.rouen.fullStack.GestShop.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class IntervalleHeure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private LocalDateTime ouverture ;
    private LocalDateTime fermeture ;
    
    
    public IntervalleHeure() {
    }

    public IntervalleHeure(LocalDateTime ouverture, LocalDateTime fermeture) {
		this.ouverture = ouverture;
		this.fermeture = fermeture;
	}


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOuverture() {
        return ouverture;
    }

    public void setOuverture(LocalDateTime ouverture) {
        this.ouverture = ouverture;
    }

    public LocalDateTime getFermeture() {
        return fermeture;
    }

    public void setFermeture(LocalDateTime fermeture) {
        this.fermeture = fermeture;
    }

    
}
