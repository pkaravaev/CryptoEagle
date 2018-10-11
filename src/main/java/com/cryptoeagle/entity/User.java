package com.cryptoeagle.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

import static com.cryptoeagle.entity.BaseEntity.START_SEQ;


@Entity
@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.GET_ALL, query = "SELECT user FROM User user"),
        @NamedQuery(name = User.GET_BY_EMAIL, query = "SELECT user FROM User  user WHERE user.email=:email"),
        @NamedQuery(name = User.GET_BY_NAME, query = "SELECT user FROM User  user WHERE user.name=:name"),
        @NamedQuery(name = User.GET_BY_ID, query = "SELECT user FROM User user WHERE user.id=:id")
})
@Table(name = "appuser")
public class User implements UserDetails {


    public static final String DELETE = "User.delete";
    public static final String GET_BY_ID = "User.get";
    public static final String GET_BY_NAME = "User.getByName";
    public static final String GET_ALL = "User.getAll";
    public static final String GET_BY_EMAIL = "User.getByEmail";

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore
    public boolean isNew() {
        return id == 0;
    }

    @Size(min = 3, max = 15)
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String email;
    @Size(min = 7)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    Collection<Role> roles = new HashSet<>();

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @NotNull
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Blog> blogs = new ArrayList<>();


    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return name;
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

    @Override
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}