package fr.univ.rouen.fullStack.GestShop.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import fr.univ.rouen.fullStack.GestShop.models.IntervalleHeure;
import fr.univ.rouen.fullStack.GestShop.repository.IntervalleHeureRepository;

@Service
public class InterValleHeureService {
    private static Logger LOGGER= LoggerFactory.getLogger(InterValleHeureService.class);
	private IntervalleHeureRepository intervalleHeureRepository;

    public InterValleHeureService(IntervalleHeureRepository intervalleHeureRepository) {
        this.intervalleHeureRepository = intervalleHeureRepository;
    }
    // create a new intervalle
    public Optional<IntervalleHeure> create(IntervalleHeure intervalleHeure)  {
        LOGGER.info("Tentative de creation  d' une Intervalle");
    	Optional<IntervalleHeure> intervalle =Optional.empty() ;
        if (! intervalleHeureRepository.findByOuvertureAndFermeture(intervalleHeure.getOuverture(),intervalleHeure.getFermeture()).isPresent()){
        	intervalle =Optional.of(intervalleHeureRepository.save(intervalleHeure)) ;

        }
        return intervalle;
    }
  //find by ouverture et fermeture
    public Optional<IntervalleHeure> findbyOuvertureetFetmeture(LocalDateTime ouverture,LocalDateTime fermeture) {
		return intervalleHeureRepository.findByOuvertureAndFermeture(ouverture,fermeture);
    }

  // delete By Id A intervalle
  public void deleteById(long id ){
        Optional<IntervalleHeure> intervalleHeure=intervalleHeureRepository.findById(id);
        if(intervalleHeure.isPresent()){
        	intervalleHeureRepository.delete(intervalleHeure.get());
        }
  }
    public List<IntervalleHeure> allintervalle(){
        return (List<IntervalleHeure>) intervalleHeureRepository.findAll();
    }
}

