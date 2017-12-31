package it.imperato.test.security.components.impl;

import it.imperato.test.security.components.UserPasswordEncoder;
import it.imperato.test.security.model.Users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordEncoderImpl implements UserPasswordEncoder {

//    @Override
    public void encodePassword(Users user) {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String bcyptPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(bcyptPassword);
    }

//    @Override
    public void encodePasswordWithSalt(Users user) {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String bcyptPassword=passwordEncoder.encode(user.getPassword()+user.getEmail());
        user.setPassword(bcyptPassword);
    }
}
