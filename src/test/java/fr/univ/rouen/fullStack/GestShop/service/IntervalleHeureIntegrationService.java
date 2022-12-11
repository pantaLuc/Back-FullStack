package fr.univ.rouen.fullStack.GestShop.service;




import fr.univ.rouen.fullStack.GestShop.models.IntervalleHeure;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class IntervalleHeureIntegrationService {
    private static  final LocalDateTime OUVERTURE=LocalDateTime.now();
    private  static  final  LocalDateTime FERMETURE=LocalDateTime.now() ;

    @Autowired
    private  InterValleHeureService interValleHeureService ;

    @Test
    public void creation()  {
        //GIVEN
        IntervalleHeure intervalleHeure=new IntervalleHeure(OUVERTURE ,FERMETURE) ;
        //WHEN
        interValleHeureService.create(intervalleHeure);
        //THEN
        assertEquals(OUVERTURE ,intervalleHeure.getOuverture());
    }

    @Test
    public void searchbyOuvertureetFetmeture()  {
        //GIVEN
        IntervalleHeure intervalleHeure=new IntervalleHeure(OUVERTURE ,FERMETURE);
        interValleHeureService.create(intervalleHeure);
        //WHEN
        Optional<IntervalleHeure> intervalleHeure1= interValleHeureService.findbyOuvertureetFetmeture(OUVERTURE ,FERMETURE);
        //THEN
        assertEquals(OUVERTURE ,intervalleHeure1.get().getOuverture());
    }
}
