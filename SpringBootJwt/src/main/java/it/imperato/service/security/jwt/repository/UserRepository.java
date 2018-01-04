package it.imperato.service.security.jwt.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import it.imperato.service.security.jwt.model.User;

/**
 * 
 * @author Francesco
 */

public interface UserRepository 
//	extends JpaRepository<User, Long> 
	{
    User findByUsername( String username );
}

