package com.macwebapps.core.user.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by froilan.macugay@pictureworks.com.au on 20/4/17.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean enabled;

    public User() {
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
