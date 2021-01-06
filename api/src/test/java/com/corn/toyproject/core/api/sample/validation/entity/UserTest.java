package com.corn.toyproject.core.api.sample.validation.entity;

import com.corn.toyproject.core.api.sample.validation.UserGroups;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class UserTest {
    @Test
    void test_validation(){
        final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        // name 이 빈값
        final User user = User.builder().name("").age(30).build();

        final Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        // ConstraintViolation 에 실패 정보가 담긴다.
        assertEquals(1, constraintViolations.size());
        log.debug("{}", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void test_groupValidation(){
        final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        final User user = User.builder().name("").age(30).adminNumber("1234").build();

        final Set<ConstraintViolation<User>> constraintViolations1 = validator.validate(user, UserGroups.Admin.class);
        assertEquals(0, constraintViolations1.size());
        final Set<ConstraintViolation<User>> constraintViolations2 = validator.validate(user, Default.class, UserGroups.Admin.class);
        assertEquals(1, constraintViolations2.size());
    }
}
