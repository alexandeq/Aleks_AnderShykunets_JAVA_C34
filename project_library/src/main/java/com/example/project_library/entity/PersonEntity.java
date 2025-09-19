package com.example.project_library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Table(name = "persons")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class PersonEntity implements UserDetails {

    @Id
    @UuidGenerator
    private UUID id;

    private String username;
    private String password;
    private String authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
