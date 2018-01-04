package it.imperato.service.security.jwt.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import it.imperato.service.security.jwt.auth.AuthenticationFailureHandler;
import it.imperato.service.security.jwt.auth.AuthenticationSuccessHandler;
import it.imperato.service.security.jwt.auth.LogoutSuccess;
import it.imperato.service.security.jwt.auth.RestAuthenticationEntryPoint;
import it.imperato.service.security.jwt.auth.TokenAuthenticationFilter;
import it.imperato.service.security.jwt.service.impl.CustomUserDetailsService;

/**
 * 
 * @author Francesco
 *
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public final static String ROLE_ADMIN = "ADMIN";
    public final static String ROLE_USER = "USER";

	@Value("${jwt.cookie}")
    private String TOKEN_COOKIE;

    @Bean
    public TokenAuthenticationFilter jwtAuthenticationTokenFilter() throws Exception {
        return new TokenAuthenticationFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Autowired
    private CustomUserDetailsService jwtUserDetailsService;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private LogoutSuccess logoutSuccess;

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                .userDetailsService( jwtUserDetailsService )
//                .passwordEncoder( passwordEncoder() );
//
//    }

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .ignoringAntMatchers("/api/login")
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
//                .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS ).and()
//                .exceptionHandling().authenticationEntryPoint( restAuthenticationEntryPoint ).and()
//                .addFilterBefore(jwtAuthenticationTokenFilter(), BasicAuthenticationFilter.class)
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated().and()
//                .formLogin()
//                .loginPage("/api/login")
//                .successHandler(authenticationSuccessHandler)
//                .failureHandler(authenticationFailureHandler).and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
//                .logoutSuccessHandler(logoutSuccess)
//                .deleteCookies(TOKEN_COOKIE);
//
//    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
	                .ignoringAntMatchers("/api/login")
	                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
	                .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS ).and()
	                .exceptionHandling().authenticationEntryPoint( restAuthenticationEntryPoint ).and()
	                .addFilterBefore(jwtAuthenticationTokenFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                    .anyRequest().authenticated()
                .and()
                  	.formLogin()
                  	.loginPage("/api/login")
                  	.successHandler(authenticationSuccessHandler)
                  	.failureHandler(authenticationFailureHandler)
                .and()
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
                  .logout()
                  .logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
                  .logoutSuccessHandler(logoutSuccess)
                  .deleteCookies(TOKEN_COOKIE);
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                    .password("password")
//                    .roles("USER")
//            .and()
//                .withUser("manager")
//                    .password("password")
//                    .credentialsExpired(true)
//                    .accountExpired(true)
//                    .accountLocked(true)
//                    .authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES")
//                    .roles("MANAGER");
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inMemoryUserDetailsManager());
    }
    
    /**
     * Determines the resource access for different account types
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeRequests()
//                    .antMatchers("/user/create").permitAll()
//                    .antMatchers("/admin/**").hasRole(ROLE_ADMIN)
//                    .anyRequest().authenticated()
//                .and()
//                    .csrf().disable()
//                    .httpBasic();
//    }

    /**
     * Initially fills Spring Security with default accounts
     */
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        final Properties users = new Properties();
        users.put("user","password,ROLE_USER,enabled"); 
        users.put("user2","password,ROLE_USER,enabled"); 
        users.put("admin","password,ROLE_ADMIN,enabled"); 
        return new InMemoryUserDetailsManager(users);
    }
    
}