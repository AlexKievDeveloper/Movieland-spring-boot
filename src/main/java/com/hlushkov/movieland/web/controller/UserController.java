package com.hlushkov.movieland.web.controller;

import com.hlushkov.movieland.entity.User;
import com.hlushkov.movieland.repositiry.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String main(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "main";
    }

    @PostMapping("/add")
    public void addUser(@RequestParam String name, @RequestParam String email, HttpServletResponse response) throws IOException {
        User user = new User(name, email);
        log.info("User to save: {}", user);
        userRepository.save(user);
        response.sendRedirect("/");
    }
}
