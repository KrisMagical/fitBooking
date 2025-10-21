package com.fitness.booking.Model;

import com.fitness.booking.Model.Enums.ExperienceLevel;
import com.fitness.booking.Model.Enums.Role;
import com.fitness.booking.Model.Enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@Table(name = "users", indexes = {
        @Index(name = "idx_users_phone", columnList = "phone", unique = true),
        @Index(name = "idx_users_email", columnList = "email")
})
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Column(length = 128, unique = true)
    private String username;
    @Column(length = 24, nullable = false, unique = true)
    private String phone;
    @Column(length = 128,unique = true)
    private String email;
    @Column(nullable = false, length = 256)
    private String passwordHash;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private UserStatus userStatus;

    @Column(length = 64)
    private String fullName;

    @Column(length = 16)
    private String gender;

    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(length = 16)
    private ExperienceLevel experienceLevel;

    @Column(length = 128)
    private String city;

    @Column(length = 256)
    private String bio;
}
