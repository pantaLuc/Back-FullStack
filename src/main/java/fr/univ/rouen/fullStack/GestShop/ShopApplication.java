package fr.univ.rouen.fullStack.GestShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.univ.rouen.fullStack.GestShop.ShopApplication;
import fr.univ.rouen.fullStack.GestShop.models.Role;
import fr.univ.rouen.fullStack.GestShop.service.RoleService;
import fr.univ.rouen.fullStack.GestShop.service.UtilisateurService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title ="Gestionnaire de Boutiques et produits" ,
		description = "Ce projet est un système qui permet la gestion de boutiques de produits et de catégories associées aux produits" ,
		version = "1.0" ,
		contact =@Contact(url = "https://www.linkedin.com/in/luc-perin-panta-6b0b36173/", name = "Luc PANTA & Ichraq Elaidi", email = "luc-perin.panta-pameni@univ-rouen.fr")

 )
)public class ShopApplication implements CommandLineRunner {

	@Autowired
	private RoleService roleService ;
	@Autowired
	private UtilisateurService utilisateurService ;

	public static void main(String[] args) {

		SpringApplication.run(ShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		createRole();
		Iterable<Role>  roles=roleService.allRoles();
		roles.forEach((role -> {
			System.out.println(role.getName());
		}));

		createUser();
		//System.out.println(utilisateurService.signin("panta" ,"letmein"));
	}

	public void createRole(){
		roleService.createRole("Admin" ,"Il administre les boutique");
		roleService.createRole("Livreur" ,"Il livre");
		roleService.createRole("Vendeur" ,"Il vend dans les boutiques") ;
		roleService.createRole("Admin" ,"Il administre les boutique");
	}

	public void createUser(){
		utilisateurService.signup("panta" ,"letmein" ,"Luc Perin" ,"Panta") ;
	}

}

