package com.example.yummy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

public class WebSecurityConfig {
    

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    http
        .authorizeHttpRequests((requests)-> requests
            .requestMatchers("/","/home").permitAll()
            .requestMatchers("/**.css").permitAll()
            .anyRequest().authenticated()
        )
        .formLogin((form)-> form
            .loginPage("/login")
            .permitAll()
        )
        .logout((logout)-> logout.permitAll());


        return http.build();
            
   }


   @Bean
   @Description("in memory Userdetails service registered since BD doesn't have use table")
   public UserDetailsService users() {
        //the builder will ensure the password are encoded before saving in memory
        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .build();

        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("password"))
            .roles("USER","ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user, admin);

   }

   @Bean
   public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
   }


}
