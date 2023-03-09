package fr.univ.rouen.fullStack.GestShop.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import fr.univ.rouen.fullStack.GestShop.models.Horaire;
import fr.univ.rouen.fullStack.GestShop.repository.HoraireRepository;

@Service
public class HoraireService {
    //logger
    private static final Logger LOGGER= LoggerFactory.getLogger(CategorieService.class) ;
	private HoraireRepository horaireRepository;

    public HoraireService(HoraireRepository horaireRepository) {
        this.horaireRepository = horaireRepository;
    }
    // create a new horaire
    public Optional<Horaire> create(Horaire horaire){
        LOGGER.info("Tentative Création d' une Horaire");
        return Optional.of(horaireRepository.save(horaire)) ;
    }

  // delete By Id A horaire
  public void deleteById(long id ){
        LOGGER.info("Tentative  de suppression d' une Horaire ");
        Optional<Horaire> horaire=horaireRepository.findById(id);
        if(horaire.isPresent()){
            horaireRepository.delete(horaire.get());
        }
  }
    public List<Horaire> allHoraire(){
        LOGGER.info(" Tentative Liste d'obtention de la  liste Horaires   ");
        return (List<Horaire>) horaireRepository.findAll();
    }
}