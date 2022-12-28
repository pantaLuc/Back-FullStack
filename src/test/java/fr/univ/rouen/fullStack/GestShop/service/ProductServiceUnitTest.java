package fr.univ.rouen.fullStack.GestShop.service;


import fr.univ.rouen.fullStack.GestShop.models.Boutique;
import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import fr.univ.rouen.fullStack.GestShop.models.Produit;

import fr.univ.rouen.fullStack.GestShop.repository.ProduitRepository;
import org.h2.command.dml.MergeUsing;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert.*;
import java.sql.Date;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProductServiceUnitTest {
    private static final long produit_ID = 1L;
    private static final  String product_name = "Lait";
    private static final  String description="aucune";
    private static List<Categorie> categorie=null;
    private static  String imageUrl=null ;
    private static Date date_fabrication=null ;
    private static Date date_expiration=null ;
    private static  double prix=12 ;
    private static Boutique boutique =null ;
    private  static int quantité =1;

    @Mock
    private ProduitRepository produitRepository;
    @InjectMocks
    private ProduitService produitService ;

    @Mock
    private  Produit produit;

    @Before
    public  void setUp(){
        MockitoAnnotations.initMocks(this);
        when(produitRepository.findById(produit_ID)).thenReturn(Optional.of(produit));
        when(produit.getId()).thenReturn(produit_ID);
    }

    @Test
    public void create(){
      //GIVEN
        Produit aMockproduit=new Produit(product_name ,description ,categorie ,
                imageUrl  ,prix ,boutique ,quantité);
      //WHEN
        when(produitRepository.save(any(Produit.class))).thenReturn(aMockproduit) ;
        Optional<Produit>  produit= produitService.create(product_name ,description ,categorie ,
                imageUrl ,prix ,boutique ,quantité);
      //THEN
        assertEquals(product_name ,produit.get().getNom());
    }
    @Test
    public void searchByNomUnitTest(){
        //GIVEN
        Produit aMockproduit=new Produit(product_name ,description ,categorie ,
                imageUrl  ,prix ,boutique ,quantité);
        //WHEN
        when(produitRepository.findByNom(product_name)).thenReturn(Optional.of(aMockproduit));
        Optional<Produit> produit=produitService.searchByName(product_name);
        //THEN
        assertEquals(product_name ,produit.get().getNom());
    }

    @Test
    public void searchByCategorieNom(){
        //GIVEN
        String categorie_nom="";
         Optional<Produit> aMockProduit=Optional.empty() ;
        //WHEN
        when(produitRepository.findByCategorieList(categorie_nom)).thenReturn(aMockProduit);
        Optional<Produit> produit=produitService.searchByCategorieNom(categorie_nom);
        //THEN
        assertThat(produit.isEmpty());
    }
    @Test
    public void searchByBoutiqueNom(){
        //GIVEN
        String boutique_nom="";
        Optional<Produit> aMockProduit=Optional.empty() ;
        //WHEN
        when(produitRepository.findByCategorieList(boutique_nom)).thenReturn(aMockProduit);
        Optional<Produit> produit=produitService.searchByBoutiqueNom(boutique_nom);
        //THEN
        assertThat(produit.isEmpty());
    }
    @Test
    public  void deleteTest(){
        produitService.deleteById(produit_ID);
        verify(produitRepository).delete(any(Produit.class));
    }
}
