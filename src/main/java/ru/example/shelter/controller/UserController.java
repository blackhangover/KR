package ru.example.shelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.example.shelter.model.User;
import ru.example.shelter.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String reg(Model model) { //?????????? ????????????? ? ?????? ??? ???????????
        model.addAttribute("usr", new User());
        return "user/reg";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("usr") User user) { //????? ??? ?????????? ???????????? ? ??
        userService.save(user);
        return "redirect:/login";
    }

}
