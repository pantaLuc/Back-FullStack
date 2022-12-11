package fr.univ.rouen.fullStack.GestShop.repository;

import fr.univ.rouen.fullStack.GestShop.models.Boutique;
import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import fr.univ.rouen.fullStack.GestShop.models.Produit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE )
public class ProduitRepositoryIntegrationTest {
    private static final long produit_ID = 1L;
    private static final  String product_name = "Lait";
    private static final  String description="aucune";
    private static Categorie categorie=null;
    private static  String imageUrl=null ;
    private static  double prix=12 ;
    private static Boutique boutique =null ;
    private  static int quantité =1;
    @Autowired
    private TestEntityManager entityManager ;
    @Autowired
    private  ProduitRepository produitRepository ;
    @Test
    public void findByNomTest(){
        //GIVEN
        Produit produit=new Produit(product_name ,description ,categorie ,
                imageUrl ,prix ,boutique ,quantité);

        //WHEN
        entityManager.persist(produit) ;
        Optional<Produit> produit1=produitRepository.findByNom(product_name);
        //THEN

        assertEquals(product_name , produit1.get().getNom());
    }

    @Test
    public void findBYBoutiqueNom(){
        //GIVEN
        //WHEN
        //THEN
    }

}
