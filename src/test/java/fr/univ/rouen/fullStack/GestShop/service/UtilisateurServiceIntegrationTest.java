package fr.univ.rouen.fullStack.GestShop.service;

import fr.univ.rouen.fullStack.GestShop.models.Utilisateur;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UtilisateurServiceIntegrationTest {
    private static final long produit_ = 1L;
    private static final  String USERNAME = "luc";
    private static final  String PASSWORD="letmein";
    private  static final String FIRSTNAME="Luc Perin " ;
    private static  final String LASTNAME="PANTA" ;

    @Autowired
    private UtilisateurService utilisateurService ;

    @Test
    public void signup(){
        //GIVEN

        //WHEN
        Optional<Utilisateur> utilisateur = utilisateurService.signup(USERNAME ,PASSWORD ,FIRSTNAME ,LASTNAME);
        //THEN

        assertEquals(USERNAME ,utilisateur.stream().findAny().get().getUsername());
    }

    @Test
    public void signin(){
        //GIVEN
        //WHEN
        //THEN
    }
}
