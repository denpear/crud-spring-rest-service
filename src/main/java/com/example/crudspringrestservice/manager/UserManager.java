package com.example.crudspringrestservice.manager;

import com.example.crudspringrestservice.dto.UserEntityDTO;
import com.example.crudspringrestservice.entity.UserEntity;
import com.example.crudspringrestservice.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements CrudManager<UserEntityDTO> {

    private final UserEntityRepository userEntityRepository;

    @Autowired
    public UserManager(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserEntityDTO create(UserEntityDTO object) {
        UserEntity userEntity = new UserEntity(object.getId(), object.getName(), object.getSurname(), object.getAddress()); // маппим пришедший с контроллера BaseDTO
        var returnedEntity = userEntityRepository.save(userEntity); // метод save интрефейса репозитория возвращает  сохраненную сущность
        return new UserEntityDTO(returnedEntity.getId(), returnedEntity.getName(), returnedEntity.getSurname(), returnedEntity.getAddress()); // шлем на контроллер готовенький DTO
        //TODO: м.сделать mapper'ы через MapStruct
    }

    @Override
    public UserEntityDTO read(Long id) {
        var object = userEntityRepository.findById(id);
        var returnedEntity = object.orElse(null);
        if (returnedEntity != null) {
            return new UserEntityDTO(returnedEntity.getId(), returnedEntity.getName(), returnedEntity.getSurname(), returnedEntity.getAddress());
        } else {
            return null;
        }
    }

    @Override
    public UserEntityDTO update(UserEntityDTO object) {
        //return userEntityRepository.
        var userEntity = userEntityRepository.findById(object.getId());
        if (userEntity.isPresent()) {
            var existingEntity = userEntity.get(); // только что из БД
            existingEntity.setName(object.getName()); // обновляем данными, пришедшими из контроллера
            existingEntity.setSurname(object.getSurname());
            var returnedEntity = userEntityRepository.save(existingEntity);
            return new UserEntityDTO(returnedEntity.getId(), returnedEntity.getName(), returnedEntity.getSurname(), returnedEntity.getAddress()); // шлем на контроллер готовенький DTO
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        userEntityRepository.deleteById(id);
    }
}
