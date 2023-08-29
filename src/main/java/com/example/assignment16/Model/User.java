package com.example.assignment16.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Username must not be empty")
    @Size(min = 3,message = "Username length must be more than 2")
    @Column(columnDefinition = "varchar(30) unique not null check(LENGTH(username)>=3)")
    private String username;


    @NotEmpty(message = "Password must not be empty")
    @Size(min = 8,message = "Password length must be more than 7")
    @Column(columnDefinition = "varchar(150) not null check(LENGTH(password)>=8)")
    private String password;

    //@NotEmpty(message = "Role must not be empty")
    //@Pattern(regexp = "USER|ADMIN",message = "Role must be USER or ADMIN")
    @Column(columnDefinition = "varchar(5) not null check(role='USER' or role='ADMIN')")
    private String role;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<Blog> blogs;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
