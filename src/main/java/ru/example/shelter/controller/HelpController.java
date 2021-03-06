package ru.example.shelter.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.example.shelter.model.User;

import java.util.Objects;

@ControllerAdvice //ControllerAdvice ?????????? ?? ???????? ??????????? ???, ??? ?????? ????? ????? ??????????? ??????????? ? ?????? ???????????? ??????????
public class HelpController {

    @ModelAttribute
    public void attr(Model model, @AuthenticationPrincipal User user) { //?????? ?????? ???????????? ? ?????? ?????????????
        model.addAttribute("user", Objects.requireNonNullElse(user, new User("Anon", "USER")));
    }

}
