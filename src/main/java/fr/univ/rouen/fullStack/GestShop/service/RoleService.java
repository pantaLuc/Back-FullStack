package fr.univ.rouen.fullStack.GestShop.service;


import fr.univ.rouen.fullStack.GestShop.models.Role;
import fr.univ.rouen.fullStack.GestShop.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    // Logger
    private static final Logger LOGGER= LoggerFactory.getLogger(CategorieService.class) ;

    private RoleRepository roleRepository ;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> createRole(String name  , String description){
        LOGGER.info("tentative de creation de role");
        Optional<Role> role =Optional.empty();
        if (! roleRepository.findByName(name).isPresent()){
            role = Optional.of(roleRepository.save(new Role(name,description)));
        }
        return role ;
    }

    public Optional<Role> searchByName(String nom) {
        LOGGER.info("tentative de recherche de role par nom");

        return  roleRepository.findByName("nom");
    }
    // delete By Id A categorie
    public void deleteById(long id ){
        Optional<Role> role=roleRepository.findById(id);
        if(role.isPresent()){
            roleRepository.delete(role.get());
        }
    }
    // Update aCategorie Name
    public Role updateName(long id , String nom){
        Optional<Role> categorie=roleRepository.findById(id);
        if(categorie.isPresent()){
            categorie.get().setName(nom);
        }
        return roleRepository.save(categorie.get());
    }
    public List<Role> allRoles(){
        return (List<Role>) roleRepository.findAll();
    }
}
