package fr.univ.rouen.fullStack.GestShop.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import fr.univ.rouen.fullStack.GestShop.models.Boutique;
import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import fr.univ.rouen.fullStack.GestShop.models.Utilisateur;
import fr.univ.rouen.fullStack.GestShop.service.BoutiqueService;

@RestController
@RequestMapping("/boutique")
@CrossOrigin("*")
public class ControlleurBoutique {
	@Autowired
	BoutiqueService boutiqueService;
	
	@GetMapping("/list")
	public Iterable<Boutique> allboutiques() {
	    return boutiqueService.allBoutiques();
	}
	
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('Vendeur-livreur')")
    public  @ResponseBody ResponseEntity create(@RequestBody Boutique boutique){
    	Optional<Boutique> boutiqueRS = boutiqueService.create(boutique) ;
   		if (boutiqueRS.isEmpty()) {
           return ResponseEntity.status(409).body("boutique existe");
       }else{
           return ResponseEntity.status(HttpStatus.OK).body(boutiqueRS);
       }  
    }
    
    @GetMapping("/searchboutiques")
    public @ResponseBody ResponseEntity findUtilisateurByUsername(@RequestParam String username){
        List<Boutique> listBoutiques = boutiqueService.findboutiquesByutilisateur(username);
            return ResponseEntity.status(HttpStatus.OK).body(listBoutiques);
        }
}
