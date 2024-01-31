package ru.travin.spring_boot_library.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.travin.spring_boot_library.model.BookEntity;
import ru.travin.spring_boot_library.model.UserEntity;
import ru.travin.spring_boot_library.repo.BookRepository;
import ru.travin.spring_boot_library.repo.UserRepository;

import java.awt.print.Book;
import java.util.List;
@Service
public class DatabaseServiceImpl implements DatabaseService{

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public DatabaseServiceImpl(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
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

    @Override
    public List<BookEntity> findAllBook() {
        List<BookEntity> books = bookRepository.findAll();
        return books;
    }

    @Override
    public BookEntity findByIdBook(Long id) {
        return bookRepository.findByIdBook(id);
    }

    @Override
    public void saveBook(BookEntity book) {
    bookRepository.save(book);
    }

    @Override
    public void update(Long id, BookEntity book) {
    bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
    bookRepository.deleteById(id);
    }
}
