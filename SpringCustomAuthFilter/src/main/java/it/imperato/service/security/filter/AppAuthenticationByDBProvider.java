package it.imperato.service.security.filter;

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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AppAuthenticationByDBProvider extends AbstractUserDetailsAuthenticationProvider {
	
	private static final Logger log = LoggerFactory.getLogger(AppAuthenticationByDBProvider.class);

    @Autowired
    private UserDetails userDetails;
    
	@PostConstruct
    public void initUsers() {
		// UserDetails should be retrieved from a database (or another datasource). Only one user.
		this.userDetails = new UserDetails() {       
			private static final long serialVersionUID = 1L;
			@Override
            public boolean isEnabled() {
                    return true;
            }
            @Override
            public boolean isCredentialsNonExpired() {
                    return true;
            }
            @Override
            public boolean isAccountNonLocked() {
                    return true;
            }
            @Override
            public boolean isAccountNonExpired() {
                    return true;
            }
            @Override
            public String getUsername() {
                    return "myuser";
            }
            @Override
            public String getPassword() {
                    return "password";
            }
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                    return null;
            }
        };
    }
	
    public boolean supports(Class<?> authentication) {
        log.info("[supports method - user by DB]");
        return true;
    }

    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) 
    			throws AuthenticationException {
    	// nothing
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        
    	log.info("[retrieveUser method - user by DB]");
    	log.info("Authentication = {}", authentication);
       
        if(authentication.getPrincipal().equals(this.userDetails.getUsername())
        	&& (authentication.getCredentials().equals(this.userDetails.getPassword()))) {
        	log.info("authenticated with user: "+this.userDetails);
        }
        else {
        	throw new UsernameNotFoundException("user name not found");
        }                
                
        return this.userDetails;
    }

}