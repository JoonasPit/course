package game.project.course;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests()
	.antMatchers("/resources/**").permitAll()
	.and()
    .authorizeRequests().antMatchers("/","/css/**","/leaderboard", "/game").permitAll()
    .and()
    //.authorizeRequests().antMatchers("/game","/leaderboard").authenticated()
    //.and()
    .formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/game")
		.permitAll()
		.and()
		.logout()
		.permitAll();
	 }
}
