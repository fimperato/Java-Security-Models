package it.imperato.service.security.interceptor;

import java.util.HashSet;
import java.util.Set;

//import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Francesco
 *
 */
//@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {
 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException /*, DataAccessException*/ {

		Set<GrantedAuthority> grantedAuths = new HashSet<GrantedAuthority>();
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_TestUser"));

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		String userId= "userID";
		String userName = "tester";
		String authenticator="password";

		UserDetails userdetails = new SecurityUser(userId, userName,  authenticator, enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);

		return userdetails;
	}
}
