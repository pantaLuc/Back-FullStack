package fr.univ.rouen.fullStack.GestShop.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;
import java.time.LocalTime;

@Entity
public class IntervalleHeure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime ouverture ;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime fermeture ;
    
    
    public IntervalleHeure() {
    }

    public IntervalleHeure(LocalTime ouverture, LocalTime fermeture) {
		this.ouverture = ouverture;
		this.fermeture = fermeture;
	}


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getOuverture() {
        return ouverture;
    }

    public void setOuverture(LocalTime ouverture) {
        this.ouverture = ouverture;
    }

    public LocalTime getFermeture() {
        return fermeture;
    }

    public void setFermeture(LocalTime fermeture) {
        this.fermeture = fermeture;
    }

    
}
