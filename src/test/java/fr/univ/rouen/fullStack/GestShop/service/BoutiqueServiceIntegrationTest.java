package fr.univ.rouen.fullStack.GestShop.service;

import fr.univ.rouen.fullStack.GestShop.models.Boutique;
import fr.univ.rouen.fullStack.GestShop.models.Horaire;
import fr.univ.rouen.fullStack.GestShop.models.Utilisateur;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.contentOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BoutiqueServiceIntegrationTest {
    private static  final Long ID=1L ;
    private static final String NOM="zara";
    private  static final LocalDateTime DATECREATION=LocalDateTime.now();
    private  static final List<Horaire> HORAIRE_LIST=null;
    private static final Utilisateur UTILISATEUR=null;
    private static  final String  IMAGE=null;

    @Autowired
    private BoutiqueService boutiqueService ;

    @Test
    public  void createtest(){
        //GIVEN
        Boutique boutique =new Boutique(NOM ,DATECREATION , IMAGE, HORAIRE_LIST,UTILISATEUR);

        //WHEN
        Optional<Boutique> boutique1= boutiqueService.create(boutique);
        //THEN
        assertEquals(NOM ,boutique1.get().getNom());
    }


}
