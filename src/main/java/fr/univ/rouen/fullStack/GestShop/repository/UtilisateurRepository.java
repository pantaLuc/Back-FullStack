package fr.univ.rouen.fullStack.GestShop.repository;

import fr.univ.rouen.fullStack.GestShop.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur ,Long> {

    Optional<Utilisateur> findByUsername(String username);
}
