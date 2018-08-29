package com.cryptoeagle.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.GET_ALL, query = "SELECT user FROM User user"),
        @NamedQuery(name = User.GET_BY_EMAIL, query = "SELECT user FROM User  user WHERE user.email=:email"),
        @NamedQuery(name = User.GET_BY_ID, query = "SELECT user FROM User user WHERE user.id=:id")
})
@Getter
@Setter
public class User extends BaseEntity {

    public static final String DELETE = "User.delete";
    public static final String GET_BY_ID = "User.get";
    public static final String GET_ALL = "User.getall";
    public static final String GET_BY_EMAIL = "User.getByEmail";

    @Min(3)
    private String name;
    @Column(unique = true)
    private String email;
    @Min(5)
    private String password;
    @NotNull
    private boolean enable;
    @NotNull
    private boolean admin;
    @NotNull
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Blog> blogs = new ArrayList<>();


    public User(int id, String name, String email, String password, boolean enable, boolean admin) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.enable = enable;
        this.admin = admin;
    }

    public User(String name, String email, String password, boolean enable, boolean admin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.enable = enable;
        this.admin = admin;
    }


    public User() {
    }


}
