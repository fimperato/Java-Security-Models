package it.imperato.test.security.dao.impl;


import it.imperato.test.security.dao.AbstractDao;
import it.imperato.test.security.dao.ProductsDao;
import it.imperato.test.security.model.Products;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsDaoImpl extends AbstractDao<Products> implements ProductsDao {
    @Override
    public Class<Products> getEntityClass() {
        return Products.class;
    }

    @SuppressWarnings("unchecked")
    public List<Products> getPortionProductsByCategory(String category, int startFrom, int resultQuantity) {
        //Query query =sessionFactory.getCurrentSession().createQuery("FROM Products p WHERE p.category:=category").setString()
        Query query=sessionFactory.getCurrentSession().getNamedQuery(Products.FIND_BY_CATEGORY_WITH_LIMIT)
                .setString("category", category)
                .setFirstResult(startFrom)
                .setMaxResults(resultQuantity);
        return (List<Products>)query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Products> getPortionProducts(int startFrom, int resultQuantity) {
        Query query=sessionFactory.getCurrentSession().createQuery("FROM Products ");
        query.setFirstResult(startFrom);
        query.setMaxResults(resultQuantity);
        return query.list();
    }


    public Products findByName(String name) {
        return (Products) sessionFactory.getCurrentSession().getNamedQuery(Products.FIND_BY_NAME).setString("name",name);
        //return (Products)sessionFactory.getCurrentSession().createCriteria(Products.class).add(Restrictions.like("name",name)).uniqueResult();
    }

    public int getProductPrice(int productId) {
        Query query=sessionFactory.getCurrentSession().createQuery("SELECT pr.price FROM Products pr WHERE pr.id=:productId ");
        query.setParameter("productId",productId);
        return (Integer)query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Products> getByCategory(String category) {
        Query query=sessionFactory.getCurrentSession().getNamedQuery(Products.FIND_BY_CATEGORY_WITH_LIMIT)
                .setString("category", category);
        return (List<Products>)query.list();
    }
}
