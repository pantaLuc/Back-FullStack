package fr.univ.rouen.fullStack.GestShop.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    GestShopUserDetailsService userDetailsService ;
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/categorie/**").permitAll()
                .antMatchers("/boutique/**").permitAll()
                .antMatchers("/horaire/**").permitAll()
                .antMatchers("/intervalleheure/**").permitAll()
                .antMatchers("/produit/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .anyRequest().authenticated();
        //Desactive le csrf
        http.csrf().disable() ;
        // No session will be created or used by spring security
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(new JwtTokenFilter(userDetailsService), UsernamePasswordAuthenticationFilter.class);
        //Exception
        http.exceptionHandling();
    }
   // donnons acces à des element sans authentificatication
    @Override
    public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger-ui/**", "/v3/api-docs/**");
    }

    //Authentication Manager

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // encryptons le mot de passe
    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder(12) ;}
}
