package nl.MensErgerJeNiet.mensergerjeniet.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 @Autowired 
 private UserDetailsService userDetailsService;
 
 @Autowired
 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
	 auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
 } 
   
 @Override
 protected void configure(HttpSecurity http) throws Exception {
   http.authorizeRequests()
   .antMatchers("/", "/register","/registeruser", "/login", "/test", "/gameslist",   				// pagina's die iedereen mag gebruiken
		   		"/css/*", "/js/*", "/img/*").permitAll()			// css, js, img mag iedereen bij
   .antMatchers("/highscores").access("hasRole('ROLE_USER')") 	// users mogen bij deze pagina's
   .antMatchers("/hello", "/admin/**").access("hasRole('ROLE_ADMIN')")			// admin page test
   .antMatchers("/**").authenticated()								// ingelogde gebruikers mogen alle urls gebruiken
   .anyRequest().permitAll()
   .and()
    .formLogin().loginPage("/login")
    .usernameParameter("username").passwordParameter("password")
  .and()
    .logout().permitAll().logoutSuccessUrl("/login?logout") 
   .and()
   .exceptionHandling().accessDeniedPage("/403")
  .and()
    .csrf();
 }
  
 @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
     return new BCryptPasswordEncoder();
    }
}