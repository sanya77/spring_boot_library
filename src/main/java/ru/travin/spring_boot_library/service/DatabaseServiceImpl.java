package ru.travin.spring_boot_library.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.travin.spring_boot_library.model.BookEntity;
import ru.travin.spring_boot_library.model.UserEntity;
import ru.travin.spring_boot_library.repo.BookRepository;
import ru.travin.spring_boot_library.repo.UserRepository;

import java.util.List;

@Service
@Transactional
public class DatabaseServiceImpl implements DatabaseService {

    private final EntityManager entityManager;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public DatabaseServiceImpl(EntityManager entityManager, UserRepository userRepository, BookRepository bookRepository) {
        this.entityManager = entityManager;
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
    public List<BookEntity> addBookForPerson(Long id) {
        UserEntity user = entityManager.getReference(UserEntity.class, id);
        return user.getBook();
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


    //
    public UserEntity getBookUser(Long id) {
        BookEntity book = entityManager.getReference(BookEntity.class, id);
        return book.getUser();
    }

    // освободить книгу
    public void deleteUserForBook(Long id) {
        Query update = entityManager.createQuery("UPDATE BookEntity b SET b.user.id = ?1 where b.id = ?2");
        update.setParameter(1, null);
        update.setParameter(2, id);
        update.executeUpdate();
    }

    // назначить книгу
    public void addBookPerson(Long id, UserEntity user) {
        Query update = entityManager.createQuery("UPDATE BookEntity b SET b.user.id = ?1 where b.id = ?2");
        update.setParameter(1, user.getId()); // в первый параметр назначаем id пользователя
        update.setParameter(2, id); // во второй параметр назначаем id книги
        update.executeUpdate();
    }
}
