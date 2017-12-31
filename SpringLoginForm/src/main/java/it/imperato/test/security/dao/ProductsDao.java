package it.imperato.test.security.dao;



import java.util.List;

import it.imperato.test.security.model.Products;

/**
 * Created by Василь on 25.02.2015.
 */
public interface ProductsDao extends AbstractDaoIface<Products> {

    public Products findByName(String name);

    public List<Products> getPortionProducts(int startFrom, int resultQuantity);

    public List<Products> getByCategory(String category);

    public List<Products> getPortionProductsByCategory(String category, int startFrom, int resultQuantity);

    public int getProductPrice(int productId);

}
