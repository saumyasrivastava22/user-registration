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

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("USER")
public class User {

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
    @Column("STATE")
    private State state;
    @CreatedDate
    @Column("CREATED_AT")
    private Timestamp createdAt;
    @LastModifiedDate
    @Column("LAST_LOGGED_AT")
    private Timestamp lastLoggedAt;

}
