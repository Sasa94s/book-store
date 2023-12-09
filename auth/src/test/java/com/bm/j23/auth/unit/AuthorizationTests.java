package com.bm.j23.auth.unit;

import com.bm.j23.auth.core.SecuredAbstractTests;
import com.bm.j23.auth.utils.ModelUtils;
import com.bm.j23.auth.model.persistence.User;
import com.bm.j23.auth.model.persistence.repositories.UserRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.bm.j23.auth.utils.ModelUtils.getUser;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthorizationTests extends SecuredAbstractTests {

    @MockBean
    private UserRepository userRepository;

    @SneakyThrows
    @Test
    public void testSecuredEndpointWithoutToken() {
        User user = ModelUtils.getUser(ID);
        mvc.perform(
                        get("/api/user/{username}", user.getUsername()))
                .andExpect(status().isUnauthorized());
    }

    @SneakyThrows
    @Test
    public void testSecuredEndpointWithInvalidToken() {
        User user = ModelUtils.getUser(ID);
        String invalidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        mvc.perform(
                        get("/api/user/{username}", user.getUsername())
                                .header("Authorization", String.format("Bearer %s", invalidToken)))
                .andExpect(status().isInternalServerError());
    }

    @SneakyThrows
    @Test
    public void testSecuredEndpointWithValidToken() {
        User user = ModelUtils.getUser(ID);
        when(userRepository.findByUsername(anyString())).thenReturn(user);

        mvc.perform(
                        get("/api/user/{username}", user.getUsername())
                                .header("Authorization", String.format("Bearer %s", token)))
                .andExpect(status().isOk());

        verify(userRepository).findByUsername(user.getUsername());
    }
}
