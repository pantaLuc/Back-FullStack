package fr.univ.rouen.fullStack.GestShop.service;


import fr.univ.rouen.fullStack.GestShop.models.Boutique;

import fr.univ.rouen.fullStack.GestShop.repository.BoutiqueRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BoutiqueService {
    private BoutiqueRepository boutiqueRepository ;
    public BoutiqueService(BoutiqueRepository boutiqueRepository) {
        this.boutiqueRepository = boutiqueRepository;
    }
    public List<Boutique> allBoutiques(){
		return (List<Boutique>) boutiqueRepository.findAll();
    }
	 // create a new boutique
	    public Optional<Boutique> create(Boutique boutique) {
	
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
	        Optional<Boutique> boutique=boutiqueRepository.findById(id);
	        if(boutique.isPresent()){
	            boutiqueRepository.delete(boutique.get());
	        }
	  }
	  // Update a boutique Name
	  public Boutique updateName(long id , String nom){
	        Optional<Boutique> boutique=boutiqueRepository.findById(id);
	        if(boutique.isPresent()){
	        	boutique.get().setNom(nom);
	        }
	        return boutiqueRepository.save(boutique.get());
	  }
}
