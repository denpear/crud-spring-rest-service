package com.example.crudspringrestservice.dto;

import com.example.crudspringrestservice.entity.AddressEntity;
import com.example.crudspringrestservice.entity.TelephoneEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor

public class UserEntityDTO implements Serializable {
    private final Long id;
    private final String name;
    private final String surname;
    private final AddressEntity address;
    private final List<TelephoneEntity> phones;
}
