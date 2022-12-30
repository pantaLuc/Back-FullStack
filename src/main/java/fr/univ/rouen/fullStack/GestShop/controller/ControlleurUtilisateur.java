package fr.univ.rouen.fullStack.GestShop.controller;

import fr.univ.rouen.fullStack.GestShop.dto.UtilisateurDto;
import fr.univ.rouen.fullStack.GestShop.models.Produit;
import fr.univ.rouen.fullStack.GestShop.models.Utilisateur;
import fr.univ.rouen.fullStack.GestShop.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class ControlleurUtilisateur {

    @Autowired
    private UtilisateurService utilisateurService ;

    //Signup
    @PostMapping("/signup")
    public @ResponseBody ResponseEntity createUser(@RequestBody @Valid UtilisateurDto utilisateurDto){
        Optional<Utilisateur> utilisateur= utilisateurService.signup(utilisateurDto.getUsername(), utilisateurDto.getPassword(), utilisateurDto.getFirstName(), utilisateurDto.getLastName());
        if (utilisateur.isEmpty()) {
            return ResponseEntity.status(409).body("utilisateur existe deja");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(utilisateur);
        }

    }

    @PostMapping("/signin")
    public @ResponseBody ResponseEntity  signin(@RequestBody @Valid UtilisateurDto utilisateurDto){
    	Optional<String> token = utilisateurService.signin(utilisateurDto.getUsername() ,utilisateurDto.getPassword());
    	if (token.isEmpty()) {
            return ResponseEntity.status(404).body("utilisateur n'existe pas");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(token);
        }
    }
    @GetMapping("/allUsers")
    @PreAuthorize("hasAuthority('Admin')")
    public List<Utilisateur> ListUser(){
        return  utilisateurService.utilisateurList();
    }
    @GetMapping("/searchUtilisateur")
    public @ResponseBody ResponseEntity findUtilisateurByUsername(@RequestParam String username){
        Optional<Utilisateur> utilisateur = utilisateurService.findUtilisateurByUsername(username);
        if (utilisateur.isEmpty()) {
            return ResponseEntity.status(404).body("utilisateur n'existe pas");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(utilisateur);
        }
    }
    @GetMapping("/validToken")
    public Boolean validtoken(@RequestParam String token){
      return  utilisateurService.isConnected(token);
    }

    @GetMapping( "/searchNom")
    public  @ResponseBody ResponseEntity  searchbyNom(@RequestParam String username){
        Optional<Utilisateur> utilisateur = utilisateurService.findByUsername(username);
        if (utilisateur.isEmpty()) {
            return ResponseEntity.status(404).body("utilisateur n'existe pas");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(utilisateur);
        }
    }
}
