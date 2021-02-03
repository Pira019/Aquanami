package springBoot.demoSpringBoot.webSercurity;

import javax.sql.DataSource;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import springBoot.demoSpringBoot.dao.contrat.RoleDao;
import springBoot.demoSpringBoot.dao.contrat.UserDao;
import springBoot.demoSpringBoot.services.contrat.UserService;
 

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	 
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private DataSource dataSource;
	
	private final String USERS_QUERY = "select user_Name, password, active from tbl_users  where user_Name=?";
	
	private final String ROLES_QUERY = "select u.user_Name, r.Role_Name from tbl_users u inner join tbl_Role_users ur on(u.id=ur.User_Id) inner join tbl_roles r on(ur.Role_Id=r.id) where u.user_Name=?";
	
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(USERS_QUERY).authoritiesByUsernameQuery(ROLES_QUERY)
				.dataSource(dataSource).passwordEncoder(passwordEncoder());
	}
	
	
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/index","/","/login", "/registration","welcom","activities/**","detail/**").permitAll()
				.antMatchers("/provider/register","/admin/register","/customer/register").permitAll()
				.antMatchers("/beach/**","/activity/**","/provider/**").hasAnyAuthority("Admin","Provider")
				.antMatchers("/booking/**").hasAnyAuthority("Admin","Customer")
				.antMatchers("/admin/**").hasAnyAuthority("Admin")
				.and()
				.formLogin()
				.loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/")
				.usernameParameter("email").passwordParameter("password").and().logout().invalidateHttpSession(true)
				.clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling().accessDeniedPage("/403");
	}
	
	@Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
	
	 
	 
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
	    InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
	    return memory;
	}
	
	 

	public WebSecurityConfig() {
		// TODO Auto-generated constructor stub
	}

	 

	 

}
