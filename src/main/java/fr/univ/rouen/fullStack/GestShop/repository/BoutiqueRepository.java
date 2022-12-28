package fr.univ.rouen.fullStack.GestShop.repository;

import fr.univ.rouen.fullStack.GestShop.models.Boutique;
import fr.univ.rouen.fullStack.GestShop.models.Utilisateur;

import java.util.List;
import java.util.Optional;


import org.springframework.data.repository.CrudRepository;


public interface BoutiqueRepository extends CrudRepository<Boutique, Long> {
	Optional<Boutique> findByNom(String nom);
	
	List<Boutique> findByUtilisateur(Utilisateur utilisateur);


}
