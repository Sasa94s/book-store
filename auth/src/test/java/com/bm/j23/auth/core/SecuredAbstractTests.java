package com.bm.j23.auth.core;

import com.bm.j23.auth.utils.ModelUtils;
import com.bm.j23.auth.model.persistence.User;
import com.bm.j23.auth.security.JWTService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class SecuredAbstractTests extends AbstractTests {

    @Autowired
    protected JWTService jwtService;

    protected static String token;
    protected static String authorizationValue;

    @BeforeAll
    public void setUp() {
        User user = ModelUtils.getUser(ID);
        token = jwtService.createToken(user.getUsername());
        authorizationValue = String.format("Bearer %s", token);
    }
}
