package ru.pcs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.pcs.web.services.ProfileService;

@RequiredArgsConstructor
@Controller
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal(expression = "id") Integer currentUserId, Model model) {
        model.addAttribute("user", profileService.getUser(currentUserId));
        return "profile";
    }

}
