package ru.travin.spring_boot_library.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.travin.spring_boot_library.model.BookEntity;
import ru.travin.spring_boot_library.service.DatabaseServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class BookController {
    @Autowired
    private final DatabaseServiceImpl databaseService;
    // получаем список всех книг
    @GetMapping("/books")
    public String findAllBook(Model model){
        List<BookEntity> books = databaseService.findAllBook();
        model.addAttribute("books", books);
        return "/book/all-books";
    }
    // получаем книгу
    @GetMapping("/books/{id}")
    public String findByIdBook(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", databaseService.findByIdBook(id));
        return "/book/show-book";
    }
    @GetMapping("/books/new")
    public String createBookForm(@ModelAttribute("book") BookEntity book){
        return "/book/create-book";
    }

    @PostMapping("/books/create")
    public String createBook(@ModelAttribute("book") BookEntity book){
        databaseService.saveBook(book);
        return "redirect:/api/v1/books";
    }
    @GetMapping("/books/update/{id}")
    public String updateBookForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", databaseService.findByIdBook(id));
        return "/book/update-book";
    }
    @PatchMapping("/books/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") BookEntity book){
        databaseService.update(id, book);
        return "redirect:/api/v1/books";
    }
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        databaseService.deleteBook(id);
        return "redirect:/api/v1/books";
    }

}
