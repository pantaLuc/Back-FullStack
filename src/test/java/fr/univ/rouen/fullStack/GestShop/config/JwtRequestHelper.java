package fr.univ.rouen.fullStack.GestShop.config;


import fr.univ.rouen.fullStack.GestShop.config.JwtTokenProvider;
import fr.univ.rouen.fullStack.GestShop.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_JSON;


@Component
public class JwtRequestHelper {

    @Autowired
    private JwtTokenProvider jwtProvider;


    public  HttpHeaders withRole(String roleName){
        HttpHeaders headers = new HttpHeaders();
        Role r = new Role();
        r.setName(roleName);
        String token =  jwtProvider.createToken("anonymous", Arrays.asList(r));
        headers.setContentType(APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);
        return headers;
    }
}
