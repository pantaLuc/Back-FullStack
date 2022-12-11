package fr.univ.rouen.fullStack.GestShop.service;

import fr.univ.rouen.fullStack.GestShop.models.Role;
import fr.univ.rouen.fullStack.GestShop.repository.RoleRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RoleServiceUnitTest {

    private static final long Role_ID = 1L;

    @Mock
    private RoleRepository roleRepository ;
    @InjectMocks
    private  RoleService roleService ;
    @Mock
    private Role role;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        when(roleRepository.findById(Role_ID)).thenReturn(Optional.of(role));
        when(role.getId()).thenReturn(Role_ID);


    }

    @Test
    public void createTest(){
        //Given
        String nom="vendeur";
        String description="vends des produis ";
        Role aMockRole=new Role();
        aMockRole.setName(nom);
        aMockRole.setDescription(description);
        //WHEN
        when(roleRepository.save(any(Role.class))).thenReturn(aMockRole);
        //THEN
        Optional<Role> role=roleService.createRole(nom ,description);
        assertEquals("vendeur" ,role.get().getName());
    }
    @Test
    public void searchByNomTest(){
        //GIVEN
        String nom="vendeur";
        String description="vends des produis ";
       Role  aMockRole=new Role();
       aMockRole.setName(nom);
        aMockRole.setDescription(description);
        //WHEN
        when(roleRepository.findByName(nom)).thenReturn(Optional.of(aMockRole));
        //THEN
        assertEquals(description ,aMockRole.getDescription());
    }
    @Test
    public void deleteUnitTest(){
        //GIVEN
        //WHEN
        roleService.deleteById(Role_ID);
        //THEN
        verify(roleRepository).delete(any(Role.class));


    }
    @Test
    public void updateNomUnitTest(){
        //GIVEN
       roleService.updateName(Role_ID,"livreur");
        //WHEN
        verify(roleRepository).save(any(Role.class));
        //THEN
        verify(role).setName("livreur");

    }
    @Test
    public void allRolesUnitTest(){
        when(roleRepository.findAll()).thenReturn(Arrays.asList(role));

        //invoke and verify lookupAll
        assertEquals(roleService.allRoles().get(0), role);
    }
}
