package com.example.test312.controller;


import com.example.test312.model.User;
import com.example.test312.service.UserServise;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserServise userServise;

    public UserController(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping(value = "/users")
    public String listUsers(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userServise.listUsers());

        return "users";
    }

    @PostMapping("/users/new")
    public String addUser(@ModelAttribute("user") User user) {

        userServise.addUser(user);

        return "redirect:/users";
    }

    @GetMapping("users/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id ) {
        model.addAttribute("user", userServise.getUserById(id));

        return "edit";
    }

    @PatchMapping("users/{id}")
    public String updateUser(@ModelAttribute("user") User user) {

        userServise.updateUser(user);

        return "redirect:/users";
    }

    @GetMapping("users/{id}/delete")
    public String deleteUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userServise.getUserById(id));

        return "delete";
    }
    @DeleteMapping("users/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userServise.removeUser(id);

        return "redirect:/users";
    }





}
