package fr.univ.rouen.fullStack.GestShop.controller;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControlleurBoutiqueIntegrationTest {
    @Autowired
    private ControlleurBoutique controlleurBoutique ;
}
