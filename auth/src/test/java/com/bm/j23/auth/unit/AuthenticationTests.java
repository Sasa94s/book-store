package com.bm.j23.auth.unit;

import com.bm.j23.auth.core.AbstractTests;
import com.bm.j23.auth.utils.ModelUtils;
import com.bm.j23.auth.model.persistence.User;
import com.bm.j23.auth.model.requests.LoginUserRequest;
import com.bm.j23.auth.service.UserDetailsServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.net.URI;

import static com.bm.j23.auth.utils.ModelUtils.getUser;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureJsonTesters
public class AuthenticationTests extends AbstractTests {

    @Autowired
    private JacksonTester<LoginUserRequest> jsonLoginUser;

    @MockBean(UserDetailsServiceImpl.class)
    private UserDetailsService userDetailsService;

    @SneakyThrows
    @Test
    public void testLoginSuccess() {
        User user = ModelUtils.getUser(ID);
        UserDetails rawUser = ModelUtils.getUser(user);
        when(userDetailsService.loadUserByUsername(anyString())).thenReturn(rawUser);

        LoginUserRequest loginRequest = ModelUtils.getLoginUserRequest();
        mvc.perform(
                        post(new URI("/api/user/login"))
                                .content(jsonLoginUser.write(loginRequest).getJson())
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userDetailsService, times(1)).loadUserByUsername(user.getUsername());
    }

    @SneakyThrows
    @Test
    public void testLoginFailure() {
        User user = ModelUtils.getUser(ID);
        when(userDetailsService.loadUserByUsername(anyString()))
                .thenThrow(new UsernameNotFoundException("Invalid username or password"));

        LoginUserRequest loginRequest = ModelUtils.getLoginUserRequest();
        mvc.perform(
                        post(new URI("/api/user/login"))
                                .content(jsonLoginUser.write(loginRequest).getJson())
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());

        verify(userDetailsService, times(1)).loadUserByUsername(user.getUsername());
    }

}
