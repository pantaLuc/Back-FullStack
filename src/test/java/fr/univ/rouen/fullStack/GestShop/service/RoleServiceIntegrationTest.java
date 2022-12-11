package fr.univ.rouen.fullStack.GestShop.service;

import fr.univ.rouen.fullStack.GestShop.models.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.Date;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RoleServiceIntegrationTest {
    @Autowired
    private RoleService roleService ;


    @Test
    public void createTest(){
        //GIVEN
        String nom="vendeur";
        String description="vends des produis ";
        Optional<Role> role =Optional.empty();
        //WHEN
        role = roleService.createRole(nom ,description);
        //THEN
        assertNotNull(role);

    }
    @Test
    public  void searchByNomtest(){
        //Given
        String nom="vendeur";
        String description="vends des produis ";
      roleService.createRole(nom ,description);
        //WHEN
        Optional<Role> role=roleService.searchByName(nom);
        //THEN
        assertNotNull(role);
    }
    @Test
    public void deleteTest(){
        //Given
        String nom="vendeur";
        String description="vends des produis ";
        Optional<Role> role= roleService.createRole(nom ,description);
        //WHEN
        roleService.deleteById(role.get().getId());
        //THEN
        assertEquals(0,role.stream().toArray().length-1);
    }
    @Test
    public void updateNomtest(){
        //Given
        String nom="vendeur";
        String description="vends des produis ";
        Optional<Role> role= roleService.createRole(nom ,description);
        //WHEN
        Role role1=roleService.updateName(role.get().getId(),"livreur");
        //THEN
        assertEquals("livreur" ,role1.getName());
        assertEquals(description ,role1.getDescription());
    }
    @Test
    public  void allCategorieTest(){
        //GIVEN
        String nom="Vendeur";
        String description="vends des produis ";
        Optional<Role> role= roleService.createRole(nom ,description);
        //WHEN
         List<Role> roles =roleService.allRoles() ;
        //THEN
        assertEquals(3,roles.size());
    }
}
