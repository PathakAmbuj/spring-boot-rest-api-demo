package com.boot.entity.user;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Builder
@Jacksonized
public class User {

    private static final String DEFAULT_VALUE = "DEFAULT_VALUE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name is mandatory")
    @Size(min = 2, max = 15, message = "First Name should be at least 2 letter and maximum 15 letter")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @Builder.Default
    private String language = DEFAULT_VALUE;
    //@NotBlank(message = "email is mandatory")
    //@Column(nullable = false, unique = true)
    //@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "email is not correct")
    @Builder.Default
    private String email = DEFAULT_VALUE;

    @Builder.Default
    private String address = DEFAULT_VALUE;

    public User(String fname, String lname, String lang, String mail, String addr) {
        this.firstName = fname;
        this.lastName = lname;
        this.language = lang;
        this.email = mail;
        this.address = addr;
    }
}
