package fr.univ.rouen.fullStack.GestShop.service;

import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CategoryIntegrationTest {
    private static final  Long ID=1L ;
    private static  final  String NOM="laitiere";
    private static  final String DESCRIPTION="Categorie  pour les laits";

    @Autowired
    private CategorieService categorieService ;


    @Test
    public void createTest(){
        //GIVEN
        Optional<Categorie> categorie =Optional.empty();
        //WHEN
        categorie = categorieService.create(NOM ,DESCRIPTION);
        //THEN

        assertNotNull(categorie);
        assertEquals(NOM,categorie.stream().findFirst().get().getNom());
    }
  @Test
  public  void searchByNomtest() throws ChangeSetPersister.NotFoundException {
       //Given
        categorieService.create(NOM,DESCRIPTION);
       //WHEN
        Optional<Categorie> categorie1=categorieService.searchByName(NOM);
       //THEN
        assertNotNull(categorie1);
  }
  @Test
  public void deleteTest(){
      //Given

     Optional<Categorie> categorie= categorieService.create(NOM ,DESCRIPTION);
      //WHEN
       categorieService.deleteById(ID);
      //THEN
      assertEquals(categorieService.allCategorie().size()-1,0);
  }

  /*@Test
  public void updateNomtest(){
      //Given

      Optional<Categorie> categorie= categorieService.create(NOM,DESCRIPTION);
      //WHEN
      Categorie categorie1=categorieService.updateName(ID,"beauté");
      //THEN
      assertEquals("beauté" ,categorie1.getNom());
      assertEquals(DESCRIPTION ,categorie1.getDescription());
  }*/
@Test
  public  void allCategorieTest(){
        //GIVEN
    Optional<Categorie> categorie= categorieService.create(NOM,DESCRIPTION);
      //WHEN
      List<Categorie> categories =categorieService.allCategorie() ;
      //THEN
      assertEquals(1,categories.size());
  }
}
