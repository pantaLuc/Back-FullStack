package fr.univ.rouen.fullStack.GestShop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import fr.univ.rouen.fullStack.GestShop.dto.CategoryDto;
import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import fr.univ.rouen.fullStack.GestShop.service.CategorieService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/categorie")
@CrossOrigin("*")
public class ControlleurCategorie {

        @Autowired
        private CategorieService categorieService ;

        @PostMapping("")
        //@PreAuthorize("hasAuthority('Vendeur')")
        public @ResponseBody ResponseEntity create(@RequestBody @Valid  CategoryDto categoryDto ){
        	Optional<Categorie> categorie = categorieService.create(categoryDto.getNom() ,categoryDto.getDescription()) ;
       		if (categorie.isEmpty()) {
               return ResponseEntity.status(404).body("categorie existe");
           }else{
               return ResponseEntity.status(HttpStatus.OK).body(categorie);
           }
        }

        @GetMapping( "/list")
        public List<Categorie> allCategorie(){
            return  categorieService.allCategorie();
        }
        @GetMapping( "/searchNom")
        public @ResponseBody ResponseEntity  searchbyNom(@RequestParam String nom)  {
        	Optional<Categorie> categorie = categorieService.searchByName(nom);
       		if (categorie.isEmpty()) {
               return ResponseEntity.status(404).body("categorie n'existe pas");
           }else{
               return ResponseEntity.status(HttpStatus.OK).body(categorie);
           }
        }
        @DeleteMapping( "")
        public void delete(@RequestParam Long id){
            categorieService.deleteById(id);
        }
        @PutMapping( "")
        public @ResponseBody ResponseEntity  updateCategorie(@RequestBody Categorie cat){
        	Categorie categorie = categorieService.updateName(cat);
       		if (categorie == null) {
               return ResponseEntity.status(404).body("categorie n'existe pas");
           }else{
               return ResponseEntity.status(HttpStatus.OK).body(categorie);
           }
        }


}
