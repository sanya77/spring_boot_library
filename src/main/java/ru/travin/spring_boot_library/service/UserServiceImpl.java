package ru.travin.spring_boot_library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.travin.spring_boot_library.model.UserEntity;
import ru.travin.spring_boot_library.repo.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAllUser() {
        List<UserEntity> users = userRepository.findAll();
        return users;
    }

    @Override
    public UserEntity findByIdUser(Long id) {
        return userRepository.findByIdUser(id);
    }

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
