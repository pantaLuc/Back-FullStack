package fr.univ.rouen.fullStack.GestShop.repository;

import fr.univ.rouen.fullStack.GestShop.models.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration
public class RoleRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager ;

    @Autowired
    private RoleRepository roleRepository ;

    @Test
    public void findByNameTest(){
        // GIVEN
        Role aNewRole = new Role();
        aNewRole.setName("vendeur");
        aNewRole.setDescription("vends des produits");

        // WHEN
        entityManager.persist(aNewRole);
        Optional<Role> role =roleRepository.findByName("vendeur");
        // THEN
        assertEquals("vendeur" ,role.get().getName());
    }

}
