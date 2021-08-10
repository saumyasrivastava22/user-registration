package com.codedefnotfound.userregistration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Setter
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class UserProfile {

    private @NonNull String username;

    private @NonNull String firstName;
    private String lastName;

    private @NonNull String email;
    private String mobile;

    private @NonNull String password;

    /* for internal use only */
    @JsonIgnore
    private State state;
}
