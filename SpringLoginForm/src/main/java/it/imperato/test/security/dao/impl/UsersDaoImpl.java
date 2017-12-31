package it.imperato.test.security.dao.impl;


import it.imperato.test.security.dao.AbstractDao;
import it.imperato.test.security.dao.UsersDao;
import it.imperato.test.security.model.Users;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoImpl extends AbstractDao<Users> implements UsersDao {
    @Override
    public Class<Users> getEntityClass() {
        return Users.class;
    }

    public Users findByEmail(String email) {

       //return (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.like("email",email)).uniqueResult();
        Query quety=sessionFactory.getCurrentSession().getNamedQuery(Users.GET_BY_EMAIL).setParameter("email",email);
        return (Users)quety.uniqueResult();
    }

    public List<Users> getPortionUsers(int startFrom, int resultQuantity) {

        Query query=sessionFactory.getCurrentSession().createQuery("from Users ");
        query.setFirstResult(startFrom);
        query.setMaxResults(resultQuantity);

        return query.list();
    }
}
