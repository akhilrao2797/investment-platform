package com.invest.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.invest.lib.config.NotNullAndNotEmpty;
import com.invest.lib.model.Role;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@JsonSubTypes({
        @JsonSubTypes.Type(value = Analyst.class, name = "analyst"),
        @JsonSubTypes.Type(value = Trader.class, name = "trader")
})
@MappedSuperclass
public abstract class Person {

    @NotNullAndNotEmpty
    String name;

    @NotNullAndNotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;

    @Past
    LocalDate dateOfBirth;

    @JsonIgnore
    Role role;

    @NotNullAndNotEmpty
    String phoneNumber;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
