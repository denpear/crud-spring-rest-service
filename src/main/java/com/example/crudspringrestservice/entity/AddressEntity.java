package com.example.crudspringrestservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.persistence.Transient;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "addresses")
public class AddressEntity {


    @Transient
    @JsonIgnore
    private UserEntity user;

    @NotNull
    protected String street;

    @NotNull
    protected String zipcode;

    @NotNull
    protected String city;
}