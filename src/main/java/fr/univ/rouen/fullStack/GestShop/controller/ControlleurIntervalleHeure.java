package fr.univ.rouen.fullStack.GestShop.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.univ.rouen.fullStack.GestShop.dto.CategoryDto;
import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import fr.univ.rouen.fullStack.GestShop.models.IntervalleHeure;
import fr.univ.rouen.fullStack.GestShop.models.Produit;
import fr.univ.rouen.fullStack.GestShop.service.InterValleHeureService;

@RestController
@RequestMapping("/intervalleheure")
@CrossOrigin("*")
public class ControlleurIntervalleHeure {

	@Autowired
    private InterValleHeureService interValleHeureService ;

    @PostMapping("")
    public @ResponseBody ResponseEntity create(@RequestBody IntervalleHeure intervalle ) {
    	Optional<IntervalleHeure> interval = interValleHeureService.create(intervalle);
    	if (interval.isEmpty()) {
            return ResponseEntity.status(404).body("intervalle existe");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(interval);
        }
    }
    @GetMapping("/list")
    public List<IntervalleHeure> allIntervalle(){
        return  interValleHeureService.allintervalle();
    }
    @GetMapping( "/search")
    public @ResponseBody ResponseEntity search(@RequestParam String ouverture,@RequestParam String fermeture){
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    	LocalTime ouvertureTime = LocalTime.parse(ouverture, formatter);
    	LocalTime fermetureTime = LocalTime.parse(fermeture, formatter);
    	Optional<IntervalleHeure> intervalle = interValleHeureService.findbyOuvertureetFetmeture(ouvertureTime,fermetureTime);
        if (intervalle.isEmpty()) {
            return ResponseEntity.status(404).body("intervalle n' existe pas");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(intervalle);
        }
    }


    @DeleteMapping( "")
    public void delete(@RequestParam Long id){
        interValleHeureService.deleteById(id);
    }

}
