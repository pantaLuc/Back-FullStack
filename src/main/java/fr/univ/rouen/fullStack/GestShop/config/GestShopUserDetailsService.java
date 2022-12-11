package fr.univ.rouen.fullStack.GestShop.config;

import fr.univ.rouen.fullStack.GestShop.models.Utilisateur;
import fr.univ.rouen.fullStack.GestShop.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.security.core.userdetails.User.withUsername;

@Component
public class GestShopUserDetailsService implements UserDetailsService {
    @Autowired
    private UtilisateurRepository utilisateurRepository ;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    // Extraction des information d' un User
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur=utilisateurRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Utilisateur non trouvé pour :" + username)) ;
        return withUsername(utilisateur.getUsername())
                .password(utilisateur.getPassword())
                .authorities(utilisateur.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

    public Optional<UserDetails> loadUserByJwtToken(String jwtToken) {
        if (jwtTokenProvider.isValidToken(jwtToken)) {
            return Optional.of(
                    withUsername(jwtTokenProvider.getUsername(jwtToken))
                            .authorities(jwtTokenProvider.getRoles(jwtToken))
                            .password("") //token does not have password but field may not be empty
                            .accountExpired(false)
                            .accountLocked(false)
                            .credentialsExpired(false)
                            .disabled(false)
                            .build());
        }
        return Optional.empty();
    }
    //Extract the username from the JWT then lookup the user in the database.
    public Optional<UserDetails> loadUserByJwtTokenAndDatabase(String jwtToken) {
        if (jwtTokenProvider.isValidToken(jwtToken)) {
            return Optional.of(loadUserByUsername(jwtTokenProvider.getUsername(jwtToken)));
        } else {
            return Optional.empty();
        }
    }
}
