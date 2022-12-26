package fr.univ.rouen.fullStack.GestShop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univ.rouen.fullStack.GestShop.models.IntervalleHeure;
import fr.univ.rouen.fullStack.GestShop.service.InterValleHeureService;
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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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
	@Autowired
	private InterValleHeureService interValleHeureService ;

	public static void main(String[] args) {

		SpringApplication.run(ShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		createRole();
		Iterable<Role>  roles=roleService.allRoles();
		roles.forEach((role -> {
			System.out.println(role.getName()+role.getId());
		}));
		createUser();
		//createIntervalle();
		Iterable<IntervalleHeure> intervalleHeures=interValleHeureService.allintervalle();
		intervalleHeures.forEach((intervalleHeure -> {
			System.out.println(intervalleHeure.getId());
		}));
		//System.out.println(utilisateurService.signin("panta" ,"letmein"));
	}

	// creation des rôles à partir de fake data
	public void createRole() throws IOException {
		String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/fakeData/ListRoles.json")), StandardCharsets.UTF_8);
		ObjectMapper objectMapper = new ObjectMapper();
		List<Role> roles = objectMapper.readValue(jsonString, new TypeReference<List<Role>>(){});
		for (Role role : roles) {
			roleService.createRole(role.getName(),role.getDescription());
		}
	}

	// creation des Intervalles

	public  void createIntervalle() throws IOException {
		String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/fakeData/ListIntervalles.json")), StandardCharsets.UTF_8);
		ObjectMapper objectMapper = new ObjectMapper();
		List<IntervalleHeure> intervalleHeures = objectMapper.readValue(jsonString, new TypeReference<List<IntervalleHeure>>(){});
		for (IntervalleHeure intervalleHeure : intervalleHeures) {
			interValleHeureService.create(intervalleHeure);
		}
	}

	public void createUser(){
		utilisateurService.signup("panta" ,"letmein" ,"Luc Perin" ,"Panta") ;
	}

}

