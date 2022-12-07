package fr.univ.rouen.fullStack.GestShop.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Horaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private JourSemaine joursemaine ;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "horaire_intervalleHeure", joinColumns
            = @JoinColumn(name = "horaire_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "intervalleHeure_id",
                    referencedColumnName = "id"))
    private List<IntervalleHeure> intervalleHeure;
    
    private Boolean estEnCongé ;

    public Horaire() {
    }

    public Horaire(JourSemaine joursemaine, IntervalleHeure intervalleHeure, Boolean estEnCongé) {
		this.joursemaine = joursemaine;
		this.intervalleHeure =  Arrays.asList(intervalleHeure);
		this.estEnCongé = estEnCongé;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JourSemaine getJoursemaine() {
        return joursemaine;
    }

    public void setJoursemaine(JourSemaine joursemaine) {
        this.joursemaine = joursemaine;
    }

    public List<IntervalleHeure> getIntervalleHeure() {
        return intervalleHeure;
    }

    public void setIntervalleHeure(List<IntervalleHeure> intervalleHeure) {
        this.intervalleHeure = intervalleHeure;
    }

    public Boolean getEstEnCongé() {
        return estEnCongé;
    }

    public void setEstEnCongé(Boolean estEnCongé) {
        this.estEnCongé = estEnCongé;
    }
}
