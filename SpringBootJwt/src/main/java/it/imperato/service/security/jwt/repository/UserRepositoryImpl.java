package it.imperato.service.security.jwt.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.imperato.service.security.jwt.model.User;

@Component
@Qualifier("userRepositoryImpl")
public class UserRepositoryImpl implements UserRepository {

	/**
	 * Versione fake in assenza di connessione a un DB.
	 */
	@Override
	public User findByUsername(String username) {
		User user = new User();
		user.setFirstname("user");
		user.setLastname("user");
		user.setId(1L);
		user.setPassword("password");
		user.setUsername("user");
		return user;
	}

}
