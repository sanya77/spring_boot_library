package ru.travin.spring_boot_library.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.travin.spring_boot_library.model.UserEntity;
import ru.travin.spring_boot_library.service.DatabaseServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final DatabaseServiceImpl databaseService;

    // получение всех пользователей
    @GetMapping("/users")
    public String findAllUser(Model model) {
        List<UserEntity> users = databaseService.findAllUser();
        model.addAttribute("users", users);
        return "/user/all-users";
    }

    // получение одного пользователя по id
    @GetMapping("/users/{id}")
    public String findByIdUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", databaseService.findByIdUser(id));
        model.addAttribute("books", databaseService.addBookForPerson(id));

        return "/user/show-user";
    }

    // получение страницы создание нового пользователя
    @GetMapping("/users/new")
    public String createUserForm(@ModelAttribute("user") UserEntity user) {
        return "/user/create-user";
    }

    // выполнение метода выше
    @PostMapping("/users/create")
    public String createUser(@ModelAttribute("user") UserEntity user) {
        databaseService.saveUser(user);
        return "redirect:/api/v1/users";
    }

    //получение формы для редактирования пользователя
    @GetMapping("/users/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", databaseService.findByIdUser(id));
        return "/user/update-user";
    }

    // выполнения метода выше
    @PatchMapping("/users/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") UserEntity user) {
        databaseService.updateUser(id, user);
        return "redirect:/api/v1/users";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        databaseService.deleteUser(id);
        return "redirect:/api/v1/users";
    }
}
