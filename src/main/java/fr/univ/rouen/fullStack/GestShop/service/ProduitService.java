package fr.univ.rouen.fullStack.GestShop.service;

import fr.univ.rouen.fullStack.GestShop.models.Boutique;
import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import fr.univ.rouen.fullStack.GestShop.models.Produit;
import fr.univ.rouen.fullStack.GestShop.repository.ProduitRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
    /*Creation d'un produit */
    public Optional<Produit> create(String product_name , String description, List<Categorie> categorie,
     String imageUrl, double prix , Boutique boutique , int quantité ){
        Optional<Produit> produit=Optional.empty() ;

        produit=Optional.of(produitRepository.save(new Produit(product_name ,description ,categorie ,
                imageUrl  ,prix ,
                boutique ,quantité)));
       return produit;
    }

    public Optional<Produit> searchByName(String nom){
    	Optional<Produit> produit =Optional.empty() ;
        if(!produitRepository.findByNom(nom).isPresent()){
            produit=produitRepository.findByNom(nom) ;
        }
        return produit ;
    }

    // recherche  par  Categorie
    public Optional<Produit> searchByCategorieNom(String nom){
        Optional<Produit> produits =Optional.empty() ;
        if( produitRepository.findByCategorieList(nom).isPresent()){
            produits=produitRepository.findByCategorieList(nom) ;
        }
        return produits ;
    }
    // recherche par le nom de la boutique
    public Optional<Produit> searchByBoutiqueNom(String nom){
        Optional<Produit> produits=Optional.empty() ;
        if(produitRepository.findAllByBoutique_Nom(nom).isPresent()){
            produits=produitRepository.findAllByBoutique_Nom(nom);
        }
        return produits;
    }
    // Modifier Un produit
    public Produit updateProduit(Produit produit){
        if( produitRepository.findById(produit.getId()).isPresent()){
            return produitRepository.save(produit);
        }
		return null;
    }
  // delete Method
    public void deleteById(long id ){
        Optional<Produit> produit=produitRepository.findById(id);
        if(produit.isPresent()){
            produitRepository.delete(produit.get());
        }
    }
    //all Categorie
    public List<Produit> allProduct(){
        return produitRepository.findAll();
    }
}
