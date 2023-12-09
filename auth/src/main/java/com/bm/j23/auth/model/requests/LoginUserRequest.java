package com.bm.j23.auth.model.requests;

import com.bm.j23.auth.security.validator.annotation.ValidUsername;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginUserRequest {

    @NotBlank(message = "username is mandatory")
    @ValidUsername
    private String username;

    @NotBlank(message = "New password is mandatory")
    private String password;

}
