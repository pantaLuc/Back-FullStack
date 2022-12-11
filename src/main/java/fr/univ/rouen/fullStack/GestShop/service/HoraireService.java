package fr.univ.rouen.fullStack.GestShop.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.univ.rouen.fullStack.GestShop.models.Horaire;
import fr.univ.rouen.fullStack.GestShop.repository.HoraireRepository;

@Service
public class HoraireService {
	private HoraireRepository horaireRepository;

    public HoraireService(HoraireRepository horaireRepository) {
        this.horaireRepository = horaireRepository;
    }
    // create a new horaire
    public Optional<Horaire> create(Horaire horaire){
        return Optional.of(horaireRepository.save(horaire)) ;
    }

  // delete By Id A horaire
  public void deleteById(long id ){
        Optional<Horaire> horaire=horaireRepository.findById(id);
        if(horaire.isPresent()){
            horaireRepository.delete(horaire.get());
        }
  }
    public List<Horaire> allHoraire(){
        return (List<Horaire>) horaireRepository.findAll();
    }
}