package ru.travin.spring_boot_library.service;

import ru.travin.spring_boot_library.model.BookEntity;

import java.util.List;

public class BookServiceImpl implements BookService{
    @Override
    public List<BookEntity> findAllBook() {
        return null;
    }

    @Override
    public BookEntity findByIdBook(Long id) {
        return null;
    }

    @Override
    public void saveBook(BookEntity book) {

    }

    @Override
    public void update(Long id, BookEntity book) {

    }

    @Override
    public void deleteBook(Long id) {

    }
}
