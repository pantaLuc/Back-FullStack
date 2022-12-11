package fr.univ.rouen.fullStack.GestShop.repository;

import fr.univ.rouen.fullStack.GestShop.models.IntervalleHeure;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IntervalleHeureRepository extends CrudRepository<IntervalleHeure, Long> {
    Optional<IntervalleHeure> findByOuvertureAndFermeture(LocalDateTime ouverture, LocalDateTime fermeture);
}
