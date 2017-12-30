package it.imperato.service.security.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AppAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	private static final Logger log = LoggerFactory.getLogger(AppAuthenticationProvider.class);
    
	private final Map<String, String> usersAndPasswords = new HashMap<>();

    @Autowired
    private PasswordEncoder passwordEncoder;
    
	@PostConstruct
    public void initUsers() {
        // add a user and password (encode password to md5)
        usersAndPasswords.put("myuser", passwordEncoder.encode("password"));
        usersAndPasswords.put("myadmin", passwordEncoder.encode("password"));
    }
	
    public boolean supports(Class<?> authentication) {
        log.info("[supports method]");
        return true;
    }

    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) 
    			throws AuthenticationException {
    	// nothing
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        
    	log.info("[retrieveUser method]");
    	log.info("Authentication = {}", authentication);

        if (!usersAndPasswords.containsKey(username)) {
            throw new UsernameNotFoundException("User name not found : " + username);
        }
        User user = null;
        if(authentication.getPrincipal() instanceof User) {
        	user = (User) authentication.getPrincipal();
        } else {
	        String password = authentication.getCredentials().toString();
	        String encodedPassword = usersAndPasswords.get(username);
	        if (!passwordEncoder.matches(password, encodedPassword)) {
	            throw new BadCredentialsException("Wrong password");
	        }
	        user = new User(username, password, createAuthorities("role1", "role2")); 
        }
        return user;
    }

    private Collection<? extends GrantedAuthority> createAuthorities(String... roles) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
    
}