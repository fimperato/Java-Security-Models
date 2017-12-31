package it.imperato.test.security.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractDao<E> implements AbstractDaoIface<E> {

    @Autowired
    protected SessionFactory sessionFactory;

    public List<E> getAll() {
        System.out.println("From "+ getEntityClass().getCanonicalName());
        return sessionFactory.getCurrentSession().createQuery("From "+ getEntityClass().getCanonicalName()).list();
    }

    public E findById(int id) {
        return (E)sessionFactory.getCurrentSession().get(getEntityClass(),id);
    }
    
    public void save(E... entities) {
        for(E entity: entities){
            sessionFactory.getCurrentSession().save(entity);
        }
    }

    public void delete(E... entities) {
        for (E entity : entities){
            sessionFactory.getCurrentSession().delete(entity);
        }
    }

    public void update(E... entities) {
        for(E entity : entities){
            sessionFactory.getCurrentSession().update(entity);
        }

    }

    public  abstract Class<E> getEntityClass();
}
