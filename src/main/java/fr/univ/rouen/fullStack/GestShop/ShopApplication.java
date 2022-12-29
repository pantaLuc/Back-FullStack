package fr.univ.rouen.fullStack.GestShop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fr.univ.rouen.fullStack.GestShop.models.*;
import fr.univ.rouen.fullStack.GestShop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.univ.rouen.fullStack.GestShop.ShopApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
	@Autowired
	private CategorieService categorieService ;
	@Autowired
	private HoraireService horaireService ;

	public static void main(String[] args) {

		SpringApplication.run(ShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		createRole();
		createIntervalle();
		createCategorie();
		creationHoraire();
		createUser();
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
		objectMapper.registerModule(new JavaTimeModule());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		List<IntervalleHeure> intervalleHeures = objectMapper.readValue(jsonString, new TypeReference<List<IntervalleHeure>>(){});
		for (IntervalleHeure intervalleHeure : intervalleHeures) {
			String ouverture=formatter.format(intervalleHeure.getOuverture());
			String fermeture=formatter.format(intervalleHeure.getFermeture());
			//LocalTime ouvertureTime = LocalTime.parse(ouverture, formatter);
			//LocalTime fermetureTime = LocalTime.parse(fermeture, formatter);
			interValleHeureService.create(intervalleHeure);
		}
	}

	//creation des Categorie
	public void createCategorie() throws IOException {
		String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/fakeData/ListCategories.json")), StandardCharsets.UTF_8);
		ObjectMapper objectMapper = new ObjectMapper();
		List<Categorie> categories = objectMapper.readValue(jsonString, new TypeReference<List<Categorie>>(){});
		for (Categorie categorie : categories) {
			categorieService.create(categorie.getNom(),categorie.getDescription());
		}
	}
	// création d' une Liste Horaire

	public void creationHoraire() throws IOException {
		String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/fakeData/ListHoraires.json")), StandardCharsets.UTF_8);
		ObjectMapper objectMapper = new ObjectMapper();
		List<Horaire> horaires = objectMapper.readValue(jsonString, new TypeReference<List<Horaire>>(){});
		for (Horaire horaire : horaires) {
			horaireService.create(horaire);
		}
	}

	// creation  des utilisateur
	public void createUser() throws IOException {
		String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/fakeData/ListUtilisateurs.json")), StandardCharsets.UTF_8);
		ObjectMapper objectMapper = new ObjectMapper();
		List<Utilisateur> utilisateurList = objectMapper.readValue(jsonString, new TypeReference<List<Utilisateur>>(){});
		for (Utilisateur user : utilisateurList) {
			utilisateurService.signup(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName());
		}

	}

}

