package fr.univ.rouen.fullStack.GestShop.service;

import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import fr.univ.rouen.fullStack.GestShop.repository.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    // Logger
    private static final Logger LOGGER= LoggerFactory.getLogger(CategorieService.class) ;
    private CategoryRepository categoryRepository;


    public CategorieService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    // create a new categorie
    public Optional<Categorie> create(String nom, String description){
        LOGGER.info("Tentative de création d' une Categorie");
        Optional<Categorie> categorie =Optional.empty() ;
        if (! categoryRepository.findByNom(nom).isPresent()){
          categorie = Optional.of(categoryRepository.save(new Categorie(nom,description)));
        }
        return categorie ;
    }
    // search By Name a Categorie
   public Optional<Categorie> searchByName(String nom) {
        LOGGER.info("Tentative de récherche d' une catégorie par Nom");
        return  categoryRepository.findByNom("nom");
   }
  // delete By Id A categorie
  public void deleteById(long id ){
      LOGGER.info("Tentative de Suppréssion d' une Categorie");
        Optional<Categorie> categorie=categoryRepository.findById(id);
        if(categorie.isPresent()){
            categoryRepository.delete(categorie.get());
        }
  }
  // Update aCategorie Name
  public Categorie updateName(Categorie categorie){
      LOGGER.info("Tentative de modification   d' une Categorie");
        if(categoryRepository.findById(categorie.getId()).isPresent()){
            return categoryRepository.save(categorie);
        }
        return null;
  }
    public List<Categorie> allCategorie(){
        LOGGER.info("Tentative d' obtention d'une List des Categorie");
        return (List<Categorie>) categoryRepository.findAll();
    }
}
