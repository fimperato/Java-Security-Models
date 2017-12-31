package it.imperato.test.security.service.impl;

import it.imperato.test.security.dao.UsersDao;
import it.imperato.test.security.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service("userDetailsService") 
public class UserDetailServiceImpl implements UserDetailsService {
	

	@Autowired
	private UsersDao usersDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Users users=usersDao.findByEmail(email);

		if (users == null) {
			throw new UsernameNotFoundException("Not able to find user");
		}

		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(users.getRole().name());
		List<GrantedAuthority> grantedAuthorities = Arrays.asList(grantedAuthority);
		return new User(users.getEmail(), users.getPassword(), grantedAuthorities);
	}
	
}