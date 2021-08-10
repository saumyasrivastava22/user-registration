package com.codedefnotfound.userregistration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@Builder
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserProfile {
    private @NonNull String username;
    private @NonNull String firstName;
    private String lastName;
    private @NonNull String email;
    private String mobile;
    private String password;
    private State state;
}
