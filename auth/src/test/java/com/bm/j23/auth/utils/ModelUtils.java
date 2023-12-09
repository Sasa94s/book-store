package com.bm.j23.auth.utils;

import com.bm.j23.auth.model.persistence.User;
import com.bm.j23.auth.model.requests.CreateUserRequest;
import com.bm.j23.auth.model.requests.LoginUserRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelUtils {

    public static UserDetails getUser(User user) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

    public static User getUser(Long id) {
        return User.builder()
                .id(id)
                .username("Sasa94s")
                .password("$2a$10$j.dv523AuPF0nZQLBEU1LeDFzccOmfu/fisrHVZax7GaJ01e2ENbe")
                .salt("$2a$10$j.dv523AuPF0nZQLBEU1Le")
                .build();
    }

    public static CreateUserRequest getCreateUserRequest() {
        return CreateUserRequest.builder()
                .username("Sasa94s")
                .password("passw0rD!")
                .confirmPassword("passw0rD!")
                .build();
    }

    public static LoginUserRequest getLoginUserRequest() {
        return LoginUserRequest.builder()
                .username("Sasa94s")
                .password("passw0rD!")
                .build();
    }

}
