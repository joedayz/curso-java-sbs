package pe.joedayz.jpademo.security;

import java.util.Arrays;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


//  @Bean
//  @Override
//  public UserDetailsService userDetailsServiceBean() throws Exception {
//    UserDetails user = User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//
//    return new InMemoryUserDetailsManager(user);
//  }

  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().cors().and().authorizeRequests()
        .antMatchers(HttpMethod.POST, "/login").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new LoginFilter("/login",
            authenticationManager()),
            UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(new AuthenticationFilter(),
            UsernamePasswordAuthenticationFilter.class);
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource(){
    UrlBasedCorsConfigurationSource source =
        new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowedOrigins(Arrays.asList("*"));
    config.setAllowedMethods(Arrays.asList("*"));
    config.setAllowedHeaders(Arrays.asList("*"));
    config.setAllowCredentials(true);
    config.applyPermitDefaultValues();
    source.registerCorsConfiguration("/**", config);
    return source;
  }


}
