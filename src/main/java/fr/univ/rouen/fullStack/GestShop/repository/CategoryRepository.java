package fr.univ.rouen.fullStack.GestShop.repository;

import fr.univ.rouen.fullStack.GestShop.models.Categorie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Categorie ,Long> {

    Optional<Categorie> findByNom(String nom);


}
