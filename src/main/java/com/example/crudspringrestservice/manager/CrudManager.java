package com.example.crudspringrestservice.manager;

public interface CrudManager<DTO> {
    DTO create(DTO object);
    DTO read (Long id);
    DTO update (DTO object);
    void delete (Long id);
}
