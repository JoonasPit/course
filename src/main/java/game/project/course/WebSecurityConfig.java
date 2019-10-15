package game.project.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import game.project.course.controller.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserDetailServiceImpl userDetailsService;
	
	protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests()
	.antMatchers("/resources/**","/images").permitAll()
	.and()
    .authorizeRequests().antMatchers("/","/css/**").permitAll()
    .and()
    .authorizeRequests().antMatchers("/comments").authenticated()
    .and()
    .authorizeRequests().antMatchers("delete/{id}").hasAuthority("ADMIN")
    .and()
    // placeholder for altersecuritys
    //.authorizeRequests().antMatchers("delete/{id}").hasRole("ADMIN")
    //.and()  
    .formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/game")
		.permitAll()
		.and()
		.logout()
		.permitAll();
	 }
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
}
