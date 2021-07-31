package com.ericlam.mc.eldtester.sql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    public String username;

    public String firstName;
    public String lastName;
    public String password;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
