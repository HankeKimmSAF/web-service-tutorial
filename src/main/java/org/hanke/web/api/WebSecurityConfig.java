package org.hanke.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/api/employees/1").hasRole("USER")
		.antMatchers("/api/employees/2").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.logout()
		.logoutUrl("/logout")
        .and()
        .httpBasic();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("hanke").password("kimm").roles("ADMIN", "USER").and()
       	.withUser("user").password("password").roles("USER");
	}
}
