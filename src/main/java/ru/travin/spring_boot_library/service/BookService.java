package ru.travin.spring_boot_library.service;

import ru.travin.spring_boot_library.model.BookEntity;

import java.util.List;

public interface BookService {
    List<BookEntity> findAllBook();
    BookEntity findByIdBook(Long id);
    void saveBook(BookEntity book);
    void update(Long id, BookEntity book);
    void deleteBook(Long id);
}
