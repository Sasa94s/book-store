package com.bm.j23.auth.security.validator;

import com.bm.j23.auth.model.persistence.repositories.UserRepository;
import com.bm.j23.auth.security.validator.annotation.ValidUsername;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {

    private final UserRepository repository;

    @Override
    public void initialize(final ValidUsername arg0) {

    }

    @SneakyThrows
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (username == null || username.isEmpty()) return false;
        return repository.countByUsername(username) == 1;
    }

}
