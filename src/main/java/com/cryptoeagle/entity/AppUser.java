package com.cryptoeagle.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@NamedQueries({
        @NamedQuery(name = AppUser.DELETE, query = "DELETE FROM AppUser u WHERE u.id=:id"),
        @NamedQuery(name = AppUser.GET_ALL, query = "SELECT user FROM AppUser user"),
        @NamedQuery(name = AppUser.GET_BY_EMAIL, query = "SELECT user FROM AppUser  user WHERE user.email=:email"),
        @NamedQuery(name = AppUser.GET_BY_ID, query = "SELECT user FROM AppUser user WHERE user.id=:id")
})
@Getter
@Setter
public class AppUser extends BaseEntity {

    public static final String DELETE = "AppUser.delete";
    public static final String GET_BY_ID = "AppUser.get";
    public static final String GET_ALL = "AppUser.getall";
    public static final String GET_BY_EMAIL = "AppUser.getByEmail";

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
    @OneToMany(mappedBy = "appUser", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Blog> blogs = new ArrayList<>();


    public AppUser(int id, String name, String email, String password, boolean enable, boolean admin) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.enable = enable;
        this.admin = admin;
    }

    public AppUser(String name, String email, String password, boolean enable, boolean admin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.enable = enable;
        this.admin = admin;
    }


    public AppUser() {
    }


}
