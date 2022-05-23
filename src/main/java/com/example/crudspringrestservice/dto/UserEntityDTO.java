package com.example.crudspringrestservice.dto;

import com.example.crudspringrestservice.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor

public class UserEntityDTO implements Serializable {
    private final Long id;
    private final String name;
    private final String surname;
    private final AddressEntity address;
}
