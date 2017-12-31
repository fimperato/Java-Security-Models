package it.imperato.test.security.validation;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.imperato.test.security.model.Users;

@Component
public class UserValidator implements Validator {

    static final String NAME_PATTERN="^[a-zA-Z]{3,25}$";
    static final String EMAIL_PATTERN="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    static final String MOBILE_NUMBER_PATTERN="\\d{3}-\\d{7}";

    public boolean supports(Class<?> aClass) {
        return Users.class.equals(aClass);
    }

    public void validate(Object object, Errors errors) {
        Users users=(Users) object;

        validateFirstName(users.getFirstName(),errors);
        validateLastName(users.getLastName(),errors);
        validateEmail(users.getEmail(),errors);
        validatePassword(users.getPassword(),users.getConfirmPassword(),errors);
        //validateMobileNumber(users.getMobileNumber(),errors);

    }

    private void validateMobileNumber(String mobileNumber, Errors errors) {
        if(mobileNumber==null || mobileNumber.isEmpty()){
            errors.rejectValue("mobileNumber", "user.MobileNumber.emptyName","Enter a MobileNumber");
        }
        else if(!mobileNumber.matches(MOBILE_NUMBER_PATTERN)){
            errors.rejectValue("mobileNumber", "user.MobileNumber.badNumber","Enter correct mobile number");
        }
    }


    private void validateFirstName(String firstName,Errors errors){
        if(firstName==null || firstName.isEmpty()){
            errors.rejectValue("firstName", "user.FirstName.emptyName","Enter a First Name");
        }
        else if(!firstName.matches(NAME_PATTERN)){
            errors.rejectValue("firstName", "user.FirstName.containNonChar","Use only letter");
        }

    }

    private void validateLastName(String lastName,Errors errors){
        if(lastName==null || lastName.isEmpty()){
            errors.rejectValue("lastName", "user.LastName.emptyName","Enter a Last Name");
        }
        else if(!lastName.matches(NAME_PATTERN)){
            errors.rejectValue("lastName", "user.LastName.containNonChar","Use only letter");
        }
    }

    private void validateEmail(String email,Errors errors){
        if(email==null || email.isEmpty()){
            errors.rejectValue("email", "user.Email.emptyEmail","Enter a email");
        }
        else if(!email.matches(EMAIL_PATTERN)){
            errors.rejectValue("email", "user.Email.incorrectEmail","Enter a correct email");
        }

    }

    private void validatePassword(String password,String confirmPassword,Errors errors){
        if (!password.equals(confirmPassword)){
            errors.rejectValue("password","user.Password.passwordNotEquals","Password is not equal");
        }

    }

}
