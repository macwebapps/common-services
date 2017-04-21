package com.macwebapps.core.user.dto;

/**
 * Created by froilan.macugay@pictureworks.com.au on 21/4/17.
 */
public class RegisterDTO {

    private String username;

    private String password;

    private boolean enabled;

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
