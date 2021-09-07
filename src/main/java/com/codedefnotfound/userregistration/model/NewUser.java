package com.codedefnotfound.userregistration.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@Builder
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NewUser extends LoginUser {
    private @NonNull String firstName;
    private String lastName;
    private String email;
    private String mobile;

    private boolean activateUsingOtp;
}
