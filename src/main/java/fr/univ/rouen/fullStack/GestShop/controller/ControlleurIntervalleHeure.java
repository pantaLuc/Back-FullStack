package fr.univ.rouen.fullStack.GestShop.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.univ.rouen.fullStack.GestShop.models.IntervalleHeure;
import fr.univ.rouen.fullStack.GestShop.models.Produit;
import fr.univ.rouen.fullStack.GestShop.service.InterValleHeureService;
import static spark.Spark.*;
@RestController
@RequestMapping("/intervalleheure")
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
    @GetMapping( "")
    public List<IntervalleHeure> allIntervalle(){
        return  interValleHeureService.allintervalle();
    }
    @GetMapping( "/search")
    public Optional<IntervalleHeure> search(@RequestParam String ouverture,@RequestParam String fermeture){
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
    	LocalDateTime ouvertureTime = LocalDateTime.parse(ouverture, formatter);
    	LocalDateTime fermetureTime = LocalDateTime.parse(fermeture, formatter);
    	
        return  interValleHeureService.findbyOuvertureetFetmeture(ouvertureTime,fermetureTime);
    }
    @DeleteMapping( "")
    public void delete(@RequestParam Long id){
        interValleHeureService.deleteById(id);
    }

}
