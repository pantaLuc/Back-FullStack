package fr.univ.rouen.fullStack.GestShop.service;


import fr.univ.rouen.fullStack.GestShop.config.JwtTokenProvider;
import fr.univ.rouen.fullStack.GestShop.models.Boutique;
import fr.univ.rouen.fullStack.GestShop.models.Role;
import fr.univ.rouen.fullStack.GestShop.models.Utilisateur;
import fr.univ.rouen.fullStack.GestShop.repository.RoleRepository;
import fr.univ.rouen.fullStack.GestShop.repository.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    //Logger
    private static final Logger LOGGER= LoggerFactory.getLogger(UtilisateurService.class) ;

    private UtilisateurRepository utilisateurRepository ;

    private AuthenticationManager authenticationManager ;

    private RoleRepository roleRepository ;

    private PasswordEncoder passwordEncoder ;
    private JwtTokenProvider jwtTokenProvider ;
    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository, AuthenticationManager authenticationManager, RoleRepository roleRepository,
                              PasswordEncoder passwordEncoder , JwtTokenProvider jwtTokenProvider) {
        this.utilisateurRepository = utilisateurRepository;
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider=jwtTokenProvider;
    }
    // signin
     public Optional<String> signin(String username, String password){
        LOGGER.info("tentative de creation d' un utilisateur ");
        Optional<String> token = Optional.empty() ;
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByUsername(username) ;
        if (utilisateur.isPresent()){
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username ,password));
                token=Optional.of(jwtTokenProvider.createToken(username ,utilisateur.get().getRoles()));
            }catch (AuthenticationException e){
                LOGGER.info("Connexion echoué pour l' utilisateur : ",username);
            }
        }
        return token ;
     }
    //signup

    public Optional<Utilisateur> signup(String username , String password ,String firstName ,String lastName){
        LOGGER.info("Tentative de creation d' utilisateur ");
        Optional<Utilisateur> utilisateur=Optional.empty() ;
        if (! utilisateurRepository.findByUsername(username).isPresent()){
        	Optional<Role> role=roleRepository.findByName("Vendeur-livreur");
        	if(username.equals("elaidich") || username.equals("pantaluc")) {
        		role =roleRepository.findByName("Admin");
        	}
            

            utilisateur=Optional.of(utilisateurRepository.save( new Utilisateur(
                    username ,
                    passwordEncoder.encode(password),
                    firstName ,
                    lastName ,
                    role.get()
            )));
        }
        return utilisateur ;
    }

    public List<Utilisateur> utilisateurList(){
        return utilisateurRepository.findAll() ;
    }
    public Optional<Utilisateur> findUtilisateurByUsername(String username){
        return utilisateurRepository.findByUsername(username) ;
    }
}
