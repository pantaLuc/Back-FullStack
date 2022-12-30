package fr.univ.rouen.fullStack.GestShop.controller;


import fr.univ.rouen.fullStack.GestShop.dto.ProduitDto;
import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import fr.univ.rouen.fullStack.GestShop.models.Produit;
import fr.univ.rouen.fullStack.GestShop.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produit")
@CrossOrigin("*")
public class ControlleurProduit {
    @Autowired
    private ProduitService produitService ;

    @GetMapping( "/list")
    public List<Produit> produitList(){
        return  produitService.allProduct();
    }
    @PostMapping("")
    public @ResponseBody ResponseEntity   create(@RequestBody @Valid ProduitDto produitdto){
    	Optional<Produit> produit =produitService.create(
                produitdto.getNom(),produitdto.getDescription(),
                produitdto.getCategorieList(), produitdto.getImageUrl() ,
                produitdto.getPrix(),
                produitdto.getBoutique(),
                produitdto.getQuantité()
                );
    	if (produit == null) {
            return ResponseEntity.status(409).body("produit existe deja");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(produit);
        }
    }
    @GetMapping( "/searchNom")
    public  @ResponseBody ResponseEntity  searchbyNom(@RequestParam String nom){
    	Optional<Produit> produit = produitService.searchByName(nom);
    	if (produit.isEmpty()) {
            return ResponseEntity.status(404).body("produit n'existe pas");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(produit);
        }
    }
    @GetMapping( "/searchCategorieNom")
    public @ResponseBody ResponseEntity searchByCategorieNom(@RequestParam String nom){
    	Optional<Produit> produit = produitService.searchByCategorieNom(nom);
    	if (produit.isEmpty()) {
            return ResponseEntity.status(404).body("produit n'existe pas");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(produit);
        }
    }
    @GetMapping( "/searchBoutiqueNom")
    public @ResponseBody ResponseEntity searchByBoutiqueNom(@RequestParam String nom){
    	Optional<Produit> produit = produitService.searchByBoutiqueNom(nom);
    	if (produit.isEmpty()) {
            return ResponseEntity.status(404).body("produit n'existe pas");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(produit);
        }
    }
    @PutMapping( "" )
    public @ResponseBody ResponseEntity updateProduit(@RequestBody Produit produit){
    	 produit =produitService.updateProduit(produit);
    	if (produit == null) {
            return ResponseEntity.status(404).body("produit n'existe pas");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(produit);
        }
    }
    @DeleteMapping( "")
    public void delete(@RequestParam Long id){
    	produitService.deleteById(id);
        
    }

}
