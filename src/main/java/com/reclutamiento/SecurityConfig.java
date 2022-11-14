package com.reclutamiento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((auth) -> auth.anyRequest().authenticated())
				.formLogin(form->form.loginPage("/login")
				.permitAll());
		
		
		
		/*
		 * http.logout(logout -> logout .logoutUrl("/my/logout")
		 * .logoutSuccessUrl("/my/index") .logoutSuccessHandler()
		 * .invalidateHttpSession(true) .addLogoutHandler(null) .deleteCookies("asd") );
		 */
		 
		
		return http.build();
	}
}
