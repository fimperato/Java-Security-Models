package it.imperato.test.security.dao;

import java.util.List;

public interface AbstractDaoIface<E> {

    public E findById(int id);

    public List<E> getAll();

    public void save(E... entity);

    public void delete(E... entity);

    public void update(E... entity);



}
