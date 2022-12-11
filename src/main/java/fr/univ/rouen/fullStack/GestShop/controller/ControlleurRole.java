package fr.univ.rouen.fullStack.GestShop.controller;


import fr.univ.rouen.fullStack.GestShop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("role")
public class ControlleurRole {
    @Autowired
    private RoleService roleService;
}
