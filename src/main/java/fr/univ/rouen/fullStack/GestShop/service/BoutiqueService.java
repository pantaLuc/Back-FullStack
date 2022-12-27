package fr.univ.rouen.fullStack.GestShop.service;


import fr.univ.rouen.fullStack.GestShop.models.Boutique;

import fr.univ.rouen.fullStack.GestShop.repository.BoutiqueRepository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BoutiqueService {
	private static Logger LOGGER= LoggerFactory.getLogger(InterValleHeureService.class);
    private BoutiqueRepository boutiqueRepository ;
    public BoutiqueService(BoutiqueRepository boutiqueRepository) {

		this.boutiqueRepository = boutiqueRepository;
    }
    public List<Boutique> allBoutiques(){
		LOGGER.info("Tentative  obtention de toutes les boutiques ");
		return (List<Boutique>) boutiqueRepository.findAll();
    }
	 // create a new boutique
	    public Optional<Boutique> create(Boutique boutique) {
			LOGGER.info("Tentative de création d' une Boutique");
	        Optional<Boutique> boutiqueresult =Optional.empty() ;
	        if (! boutiqueRepository.findByNom(boutique.getNom()).isPresent()){
	        	boutiqueresult = Optional.of(boutiqueRepository.save(boutique));
	        }
	        return boutiqueresult ;
	        }
	    // search By Name a boutique
	   public Optional<Boutique> searchByName(String nom) {
	        return  boutiqueRepository.findByNom("nom");
	   }
	  // delete By Id A boutique
	  public void deleteById(long id ){
		  LOGGER.info("Tentative de suppression d' une Boutique");
	        Optional<Boutique> boutique=boutiqueRepository.findById(id);
	        if(boutique.isPresent()){
	            boutiqueRepository.delete(boutique.get());
	        }
	  }
	  // Update a boutique Name
	  public Boutique updateName(long id , String nom){
		  LOGGER.info("Tentative de modification d' une Boutique");
	        Optional<Boutique> boutique=boutiqueRepository.findById(id);
	        if(boutique.isPresent()){
	        	boutique.get().setNom(nom);
	        }
	        return boutiqueRepository.save(boutique.get());
	  }
}
