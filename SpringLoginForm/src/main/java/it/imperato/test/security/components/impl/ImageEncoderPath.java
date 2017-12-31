package it.imperato.test.security.components.impl;

import org.springframework.stereotype.Component;

@Component
public class ImageEncoderPath {

    public String getPath(String productName){
        return productName.replaceAll(" ","").toLowerCase();
    }


    public String getImageName(String productName){
        return productName.replaceAll(" ","").toLowerCase();
    }
}
