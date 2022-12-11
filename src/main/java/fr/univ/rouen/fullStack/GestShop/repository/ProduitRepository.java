package fr.univ.rouen.fullStack.GestShop.repository;


import fr.univ.rouen.fullStack.GestShop.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    Optional<Produit> findByNom(String nom);
    @Query( "select o from Categorie o where o.nom =nom" )
    Optional<Produit> findByCategorieList(@Param("nom") String nomCategorie);
    Optional<Produit> findAllByBoutique_Nom(String nom);
}
