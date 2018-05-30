package com.diplomna.traders.dtos;

import com.diplomna.traders.models.User;

public class UserDTO {

    private String username;
    private String password;
    private String email;
    private String phone;
    private User.AccountType accountType;

    public UserDTO(String username, String password, String email, String phone, User.AccountType accountType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.accountType = accountType;
    }

    public UserDTO() {}

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public User.AccountType getAccountType() {
        return accountType;
    }
}
