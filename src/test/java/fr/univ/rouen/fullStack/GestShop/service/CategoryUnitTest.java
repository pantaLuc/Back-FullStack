package fr.univ.rouen.fullStack.GestShop.service;

import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import fr.univ.rouen.fullStack.GestShop.models.Produit;
import fr.univ.rouen.fullStack.GestShop.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.Assert.*;

import java.util.Arrays;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CategoryUnitTest {
    private static final long CATEGORIE_ID = 1L;

    @Mock
    private CategoryRepository categoryRepository ;
    @InjectMocks
    private  CategorieService categorieService ;
    @Mock
    private  Categorie categorie ;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        when(categoryRepository.findById(CATEGORIE_ID)).thenReturn(Optional.of(categorie));
        when(categorie.getId()).thenReturn(CATEGORIE_ID);


    }

    @Test
    public void createTest(){
        //Given
         String nom= "laitiere" ;
         String description="produit laitiere";
         Categorie aMockCategorie=new Categorie();
         aMockCategorie.setNom(nom);
         aMockCategorie.setDescription(description);
        //WHEN
        when(categoryRepository.save(any(Categorie.class))).thenReturn(aMockCategorie);
        //THEN
        Optional<Categorie> categorie=categorieService.create(nom ,description);
        assertEquals("laitiere" ,categorie.get().getNom());
    }
    @Test
    public void searchByNomTest(){
        //GIVEN
        String nom="laitiere";
        String description="produit laitiere";
        Categorie aMockCategorie=new Categorie();
        aMockCategorie.setNom(nom);
        aMockCategorie.setDescription(description);
        //WHEN
        when(categoryRepository.findByNom(nom)).thenReturn(Optional.of(aMockCategorie));
        //THEN
        assertEquals(description ,aMockCategorie.getDescription());
    }
    @Test
    public void deleteUnitTest(){
            //GIVEN
        //WHEN
        categorieService.deleteById(CATEGORIE_ID);
        //THEN
        verify(categoryRepository).delete(any(Categorie.class));


    }
    @Test
    public void updateNomUnitTest(){
        //GIVEN
        categorieService.updateName(categorie);
        //WHEN
        verify(categoryRepository).save(any(Categorie.class));
        //THEN
        verify(categorie).setNom("jus");

    }
    @Test
    public void allCategorieUnitTest(){
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(categorie));

        //invoke and verify lookupAll
        assertEquals(categorieService.allCategorie().get(0), categorie);
    }
}
