package com.bm.j23.auth.model.requests;

import com.bm.j23.auth.security.validator.annotation.PasswordValueMatch;
import com.bm.j23.auth.security.validator.annotation.ValidPassword;
import lombok.*;

import javax.validation.constraints.NotBlank;

@PasswordValueMatch.List({
        @PasswordValueMatch(
                field = "password",
                fieldMatch = "confirmPassword",
                message = "Passwords do not match!"
        )
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CreateUserRequest {

    @NotBlank(message = "username is mandatory")
    private String username;

    @NotBlank(message = "New password is mandatory")
    @ValidPassword
    private String password;

    @NotBlank(message = "Confirm Password is mandatory")
    @ValidPassword
    private String confirmPassword;

}
