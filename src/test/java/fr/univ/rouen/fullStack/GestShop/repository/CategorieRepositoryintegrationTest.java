package fr.univ.rouen.fullStack.GestShop.repository;


import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class CategorieRepositoryintegrationTest {
    @Autowired
    private TestEntityManager entityManager ;
    @Autowired
    private  CategoryRepository categoryRepository ;

    @Test
    public void findByNameTest(){
        // GIVEN
        Categorie aNewCategorie = new Categorie();
        aNewCategorie.setNom("vendeur");
        aNewCategorie.setDescription("vends des produits");

        // WHEN
        entityManager.persist(aNewCategorie);
        Optional<Categorie> role =categoryRepository.findByNom("vendeur");
        // THEN
       // assertEquals("vendeur" ,role.get().getNom());
    }
}
