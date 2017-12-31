package it.imperato.test.security.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.imperato.test.security.model.Products;

@Component
public class ProductValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return Products.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {

    }

    public void validateName(String name,Errors errors){
        if(name==null || name.isEmpty()){
            errors.rejectValue("name", "product.Name.emptyName","Enter a Product Name");
        }
    }

    public void validatePrice(int price,Errors errors){
        if(price<0 | price >9999 ){
            errors.rejectValue("price", "product.Price.lessThan0","Enter a Correct Price");
        }
    }

    public void validateCategory(String category,Errors errors){
        if(category==null || category.isEmpty()){
            errors.rejectValue("category", "product.Category.emptyName","Enter a Category");
        }
    }

}
