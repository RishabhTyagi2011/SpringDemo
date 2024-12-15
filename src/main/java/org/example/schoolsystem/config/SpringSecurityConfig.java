package org.example.schoolsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests
            .requestMatchers("/saveTeacher").hasRole("TEACHER")
            .anyRequest().authenticated())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
        .httpBasic(Customizer.withDefaults());
    return http.build();
  }

  @Bean
  UserDetailsService userDetailsService() {
    UserDetails student = User.withUsername("student1").password("{noop}password1").roles("STUDENT")
        .build();
    UserDetails teacher = User.withUsername("teacher1").password("{noop}password11")
        .roles("TEACHER")
        .build();
    return new InMemoryUserDetailsManager(student, teacher);
  }
}
