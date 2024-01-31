package ru.travin.spring_boot_library.service;

import ru.travin.spring_boot_library.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> findAllUser();
    UserEntity findByIdUser(Long id);
    void saveUser(UserEntity user);
    void updateUser(Long id, UserEntity user);
    void deleteUser(Long id);


}
