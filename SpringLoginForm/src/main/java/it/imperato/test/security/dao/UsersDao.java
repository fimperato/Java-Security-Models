package it.imperato.test.security.dao;



import java.util.List;

import it.imperato.test.security.model.Users;

/**
 * Created by Василь on 24.02.2015.
 */
public interface UsersDao extends AbstractDaoIface<Users> {

    public Users findByEmail(String email);

    public List<Users> getPortionUsers(int startFrom, int resultQuantity);

}
