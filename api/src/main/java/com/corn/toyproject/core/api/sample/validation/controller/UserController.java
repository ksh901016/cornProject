package com.corn.toyproject.core.api.sample.validation.controller;

import com.corn.toyproject.core.api.sample.validation.entity.User;
import com.corn.toyproject.core.api.sample.validation.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Slf4j
@RestController
public class UserController {

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(new UserValidator());
    }

    @PostMapping("/api/user")
    public void addUser(@Valid @RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            for(ObjectError obj : bindingResult.getAllErrors()){
                log.info("message : {}", obj.getDefaultMessage());
                log.info("code : {}", obj.getDefaultMessage());
                log.info("object name : {}", obj.getObjectName());
            }
        }
    }

}
