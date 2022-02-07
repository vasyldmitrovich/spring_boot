package com.shopoftrifles.controller;

import com.shopoftrifles.entity.User;
import com.shopoftrifles.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @PostMapping
    public RedirectView createUser(@ModelAttribute("user") User user) {
        userRepo.save(user);
        System.out.println("user Added ======== " + user);
        return new RedirectView("/users");
    }
    @GetMapping
    public String getUsers(Model model) {
        Iterable<User> users = userRepo.findAll();
        /*for (User user: users
             ) {
            System.out.println("models is = " + user);
        }*/
        model.addAttribute("listUsers", users);
        return "/users/users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "/users/new";
    }

}
