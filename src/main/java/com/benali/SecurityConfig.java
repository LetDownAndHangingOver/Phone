package com.benali;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@EnableGlobalMethodSecurity(securedEnabled=true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
		private DataSource dataSource;
	
    @Autowired
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception{
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select pseudo, pass_word, true from user where pseudo =?	")
		.authoritiesByUsernameQuery("select user_pseudo, roles_role from users_roles where user_pseudo =?")
		.rolePrefix("ROLE_");
	}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    		.authorizeRequests()
    		.antMatchers(   "/",
                            "/js/**",
                            "/css/**",
                            "/img/**",
                            "/webjars/**").permitAll()
    		.antMatchers("/home").permitAll()
    		.antMatchers("/inscription").permitAll()
    		.antMatchers("/inscrit").permitAll()
    		.antMatchers("/welcome").permitAll()
    		.antMatchers("/fail").permitAll()
    		.anyRequest().authenticated()
    		.and()
    		.csrf().disable()
    		.formLogin()
    		.loginPage("/connexion")
    		.permitAll()
    		.defaultSuccessUrl("/l/home", true)
    		.failureUrl("/fail")
    	.and()
    		.logout()
    		.invalidateHttpSession(true)
    		.logoutUrl("/logout")
    		.permitAll();
    }

}
