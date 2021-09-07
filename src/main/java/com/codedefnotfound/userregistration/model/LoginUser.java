package com.codedefnotfound.userregistration.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@Builder
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LoginUser extends User{

    private @NonNull String password;

    LoginUser(@NonNull String username) {
        super(username);
    }
}
