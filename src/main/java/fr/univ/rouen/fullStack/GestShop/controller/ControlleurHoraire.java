package fr.univ.rouen.fullStack.GestShop.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.univ.rouen.fullStack.GestShop.models.Horaire;
import fr.univ.rouen.fullStack.GestShop.models.IntervalleHeure;
import fr.univ.rouen.fullStack.GestShop.service.HoraireService;

@RestController
@RequestMapping("/horaire")
public class ControlleurHoraire {
	   @Autowired
       private HoraireService horaireService ;

       @PostMapping("/create")
       public  @ResponseBody ResponseEntity create(@RequestBody Horaire horaire){
    	   Optional<Horaire> horaireRS = horaireService.create(horaire) ;
       		if (horaireRS.isEmpty()) {
               return ResponseEntity.status(404).body("horaire existe");
           }else{
               return ResponseEntity.status(HttpStatus.OK).body(horaireRS);
           }
       }
       @GetMapping( "/list")
       public List<Horaire> allHoraire(){
           return  horaireService.allHoraire();
       }
       @DeleteMapping( "/delete")
       public void delete(@RequestParam Long id){
           horaireService.deleteById(id);
       }

}
