package it.imperato.test.security.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.imperato.test.security.dao.ProductsDao;
import it.imperato.test.security.model.Products;
import it.imperato.test.security.service.ProductsManager;


@Service
public class ProductsManagerImpl implements ProductsManager {

    @Autowired
    ProductsDao productsDao;

    @Override
    @Transactional
    public List<Products> getAll() {
        return productsDao.getAll();
    }

    @Override
    @Transactional
    public Products findProductById(int id) {
        return productsDao.findById(id);
    }

    @Override
    @Transactional
    public void delete(Products... products) {
        productsDao.delete(products);
    }

    @Override
    @Transactional
    public void update(Products... products) {
        productsDao.update(products);
    }

    @Override
    @Transactional
    public void save(Products... products) {
        productsDao.save(products);
    }

    @Override
    @Transactional
    public Products findByName(String name) {
        return productsDao.findByName(name);
    }

    @Override
    @Transactional
    public List<Products> getPortionProducts(int startFrom, int resultQuantity) {
        return productsDao.getPortionProducts(startFrom,resultQuantity);
    }

    @Override
    @Transactional
    public List<Products> getPortionProductsByCategory(String category, int startFrom, int resultQuantity) {
        return productsDao.getPortionProductsByCategory(category,startFrom,resultQuantity);
    }

    @Override
    @Transactional
    public int getProductPrice(int productId) {
        return productsDao.getProductPrice(productId);
    }

    @Override
    @Transactional
    public List<Products> getByCategory(String categoty) {
        return productsDao.getByCategory(categoty);
    }
}
