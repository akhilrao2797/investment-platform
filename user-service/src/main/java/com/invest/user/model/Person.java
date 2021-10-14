package com.invest.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.invest.lib.config.NotNullAndNotEmpty;
import com.invest.lib.model.Role;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Person {

    @Id
    String userId;

    @NotNullAndNotEmpty
    String name;

    @NotNullAndNotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;

    @Past
    LocalDate dateOfBirth;

    @JsonIgnore
    Role role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
