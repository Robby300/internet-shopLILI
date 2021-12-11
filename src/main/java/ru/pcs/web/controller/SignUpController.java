package ru.pcs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pcs.web.forms.SignUpForm;
import ru.pcs.web.services.SignUpService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/signUp")
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping
    public String getSignUpPage(Authentication authentication, Model model) {
        if (authentication != null) {
            return "redirect:/";
        }
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUp";
    }


    @PostMapping
    public String signUpUser(SignUpForm form) {
        signUpService.signUpUser(form);
        return "redirect:/signIn";
    }

}

