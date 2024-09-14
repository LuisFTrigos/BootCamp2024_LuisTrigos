package com.example.emazon_aux.domain.util.validations;

import com.example.emazon_aux.domain.exception.DomainException;
import com.example.emazon_aux.domain.model.UserModel;
import com.example.emazon_aux.domain.util.constants.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

    private static final String REGEX_EMAIL = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final String REGEX_PHONE = "^\\+?\\d+$";

    public UserModel validationsModel(UserModel userModel){
        userModel.setName(emptyStringValidate(userModel.getName()));
        userModel.setLastName(emptyStringValidate(userModel.getLastName()));
        userModel.setEmail(emailValidate(emptyStringValidate(userModel.getEmail())));
        userModel.setPhone(numberPhoneValidate(userModel.getPhone()));

        return userModel;
    }

    public String emptyStringValidate(String data){
        if (data.isEmpty()) {
            throw new DomainException(Constants.FIELD_CANOT_BE_EMPTY);
        }
        return data;
    }

    public String emailValidate(String email){
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher mather = pattern.matcher(email);

        if (!mather.find()){
            throw new DomainException(Constants.MAIL_BAD_REQUEST);
        }
        return email;
    }

    public String numberPhoneValidate(String phone){
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        Matcher mather = pattern.matcher(phone);
        if(!mather.find()) {
            throw new DomainException(Constants.INVALID_PHONE);
        }
        if(phone.length() > 13) {
            throw new DomainException(Constants.PHONE_NOT_BE_LONGER);
        }
        return phone;
    }
}
