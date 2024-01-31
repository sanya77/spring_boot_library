package ru.travin.spring_boot_library.service;

import ru.travin.spring_boot_library.model.BookEntity;
import ru.travin.spring_boot_library.model.UserEntity;

import java.util.List;

public interface DatabaseService {
    List<UserEntity> findAllUser();
    UserEntity findByIdUser(Long id);
    void saveUser(UserEntity user);
    void updateUser(Long id, UserEntity user);
    void deleteUser(Long id);

    List<BookEntity> findAllBook();
    BookEntity findByIdBook(Long id);
    void saveBook(BookEntity book);
    void update(Long id, BookEntity book);
    void deleteBook(Long id);
}
