package it.imperato.test.security.service.impl;


import it.imperato.test.security.dao.UsersDao;
import it.imperato.test.security.model.Users;
import it.imperato.test.security.service.UsersManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class UsersManagerImpl implements UsersManager {

    @Autowired
    UsersDao usersDao;

    @Override
    @Transactional
    public Users findUserById(int id) {
        return usersDao.findById(id);
    }

    @Override
    @Transactional
    public void save(Users... users) {
        usersDao.save(users);
    }

    @Override
    @Transactional
    public List<Users> getAll() {
        return usersDao.getAll();
    }

    @Override
    @Transactional
    public void delete(Users... users) {
        usersDao.delete(users);
    }

    @Override
    @Transactional
    public void update(Users... users) {
        usersDao.update(users);
    }

    @Override
    @Transactional
    public Users findByEmail(String email) {
        return usersDao.findByEmail(email);
    }

    @Override
    @Transactional
    public boolean createNewUser(Users users) {
        String email=users.getEmail();
        //System.out.println(users);
        Users testerUser=null;
        try {
            testerUser=usersDao.findByEmail(email);
        }
        catch (NoResultException nr){

        }
        if(testerUser==null){
            usersDao.save(users);
            return  true;
        }
        return false;
    }
}
