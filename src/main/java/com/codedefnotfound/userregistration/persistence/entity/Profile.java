package com.codedefnotfound.userregistration.persistence.entity;

import com.codedefnotfound.userregistration.model.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("PROFILE")
public class Profile {

    @Id
    @Column("ID")
    private Long id;

    @Column("USERNAME")
    private String username;
    @Column("FIRSTNAME")
    private String firstName;
    @Column("LASTNAME")
    private String lastName;
    @Column("EMAIL")
    private String email;
    @Column("MOBILE")
    private String mobile;

    /* for internal use only */
    @CreatedDate
    @Column("CREATED_AT")
    private String createdAt;
    @LastModifiedDate
    @Column("LAST_MODIFIED_AT")
    private String lastModifiedAt;
    @Column("STATE")
    private State state;
}
