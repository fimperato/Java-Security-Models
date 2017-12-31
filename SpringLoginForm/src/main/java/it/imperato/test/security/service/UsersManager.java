package it.imperato.test.security.service;

import java.util.List;

import it.imperato.test.security.model.Users;


public interface UsersManager {

    public Users findUserById(int id);

    public Users findByEmail(String email);

    public List<Users> getAll();

    public void save(Users... users);

    public void delete(Users... users);

    public void update(Users... users);

    public boolean createNewUser(Users users);

}
