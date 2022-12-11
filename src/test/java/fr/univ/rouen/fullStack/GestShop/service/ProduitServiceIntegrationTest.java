package fr.univ.rouen.fullStack.GestShop.service;

import fr.univ.rouen.fullStack.GestShop.models.Boutique;
import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import fr.univ.rouen.fullStack.GestShop.models.Produit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.ManyToOne;
import java.sql.Date;
import java.util.Optional;
import org.junit.Assert.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProduitServiceIntegrationTest {
    private static final  String product_name = "Lait";
    private static final  String description="aucune";
    private static Categorie categorie=null;
    private static  String imageUrl=null ;
    private static  double prix=12 ;
    private static Boutique boutique =null ;
    private  static int quantité =1;

    @Autowired
    private ProduitService produitService ;

    @Test
    public void createTest(){
        //GIVEN
        Optional<Produit> produit=Optional.empty();
        //WHEN
        produit= produitService.create(product_name ,description ,categorie ,imageUrl,
                        prix ,boutique ,quantité);
        //THEN
        assertEquals(product_name ,produit.get().getNom());
        assertEquals(quantité ,produit.get().getQuantité());
    }

    @Test
    public void searchbyNomTest(){
        //GIVEN
        Optional<Produit> produit=Optional.empty();
        produitService.create(product_name ,description ,categorie ,imageUrl,
                 prix ,boutique ,quantité);
        //WHEN
       produit= produitService.searchByName(product_name);
        //THEN
        assertEquals(product_name,produit.get().getNom());
    }

    @Test
    public void searchByCategorieNom(){
        //GIVEN
        String categorienom="";
        Optional<Produit> produit=Optional.empty();

        //WHEN
        produit= produitService.searchByCategorieNom(categorienom);
        //THEN
      assertThat(produit.isEmpty());
    }
    @Test
    public void searchByBoutiqueNom(){
        //Given
        String boutiquenom="";
        Optional<Produit> produit=Optional.empty();
        //WHEN
        produit= produitService.searchByBoutiqueNom(boutiquenom);
        //THEN
        assertThat(produit.isEmpty());
    }
    @Test
    public void delete(){
        //GIVEN
        Optional<Produit> produit=Optional.empty();
       produit = produitService.create(product_name ,description ,categorie ,imageUrl,
               prix ,boutique ,quantité);
        //WHEN
        produitService.deleteById(produit.get().getId());
        //THEN
        assertEquals(produitService.allProduct().size() ,produit.stream().toArray().length-1);
    }

}
