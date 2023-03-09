package fr.univ.rouen.fullStack.GestShop.controller;


import fr.univ.rouen.fullStack.GestShop.dto.CategoryDto;
import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControlleurCategorieIntegrationTest {
    private static final  String NOM = "laitiere";
    private static final  String DESCRIPTION="Categorie  pour les laits";


    @Autowired
    private ControlleurCategorie controlleurCategorie;
    //@Autowired
    //private JwtRequestHelper jwtRequestHelper ;
    @Autowired
    TestRestTemplate testRestTemplate ;

    /*@Test
    public void createTest(){
        //GIVEN
        CategoryDto categoryDto=new CategoryDto(NOM ,DESCRIPTION);
        Optional<Categorie> categorie =Optional.empty();
        //WHEN
        categorie =controlleurCategorie.create(categoryDto);
        //THEN
        assertNotNull(categorie);
        assertEquals("laitiere",categorie.get().getNom());
    }
    @Test
    public  void searchByNomtest(){
        //Given
        CategoryDto categoryDto=new CategoryDto(NOM ,DESCRIPTION);
        controlleurCategorie.create(categoryDto);

        //WHEN
        Optional<Categorie> categorie1=controlleurCategorie.searchbyNom(NOM);
        //THEN
        assertNotNull(categorie1);
    }
    @Test
    public void deleteTest(){
        //Given
        CategoryDto categoryDto=new CategoryDto(NOM ,DESCRIPTION);
        Optional<Categorie> categorie= controlleurCategorie.create(categoryDto);
        //WHEN
        controlleurCategorie.delete(categorie.get().getId());
        //THEN
        assertEquals(controlleurCategorie.allCategorie().size(),categorie.stream().toArray().length-1);
    }
    @Test
    public void updateNomtest(){
        //Given
        CategoryDto categoryDto=new CategoryDto(NOM ,DESCRIPTION);
        Optional<Categorie> categorie= controlleurCategorie.create(categoryDto);
        //WHEN
        Categorie categorie1=controlleurCategorie.updateCategorie(categorie.get().getId(),"beauté");
        //THEN
        assertEquals("beauté" ,categorie1.getNom());
        assertEquals(DESCRIPTION ,categorie1.getDescription());
    }
    @Test
    public  void allCategorieTest(){
        //GIVEN
        CategoryDto categoryDto=new CategoryDto(NOM ,DESCRIPTION);
        Optional<Categorie> categorie= controlleurCategorie.create(categoryDto);
        //WHEN
        List<Categorie> categories =controlleurCategorie.allCategorie() ;
        //THEN
        assertEquals(1,categories.size());
    }*/
}

