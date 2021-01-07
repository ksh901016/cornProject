package com.corn.toyproject.core.api.sample.validation.validator;

import com.corn.toyproject.core.api.sample.validation.entity.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        int age = user.getAge();
        String adminNumber = user.getAdminNumber();

        if(age<0){
            errors.rejectValue("age", "positive", "나이는 0 이상이어야 합니다.");
        }
        if(StringUtils.isEmpty(adminNumber)){
            errors.rejectValue("adminNumber", "isEmpty");
        }
    }
}
