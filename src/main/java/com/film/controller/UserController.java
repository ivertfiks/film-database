package com.film.controller;

import com.film.entity.Users;
import com.film.repository.UserRepository;
import com.film.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;
    private final UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "authorization";
    }

    @PostMapping("/register")
    public String registerUser(Model model,
                               @RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String confirmPassword,
                               RedirectAttributes redirectAttributes) {

        Users user = userService.getUser(username);
        if(user != null) {
            redirectAttributes.addFlashAttribute("message", "User with this username already exists");
            return "redirect:/user/register";
        }

        if(!password.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("message", "Passwords do not match");
            return "redirect:/user/register";
        }

        userService.createUser(username, email, password);
        user = userService.getUser(username);

        redirectAttributes.addFlashAttribute("message", "Registration successful");
        model.addAttribute("user", user);
        return "redirect:/";
    }

    public Users getUser(String username) {
        return userService.getUser(username);
    }

    public Users getUser(int id) {
        return userService.getUser(id);
    }
}
