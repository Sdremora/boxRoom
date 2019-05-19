package ru.sinys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sinys.dao.UserDao;
import ru.sinys.model.Role;
import ru.sinys.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Controller
public class RegistrationController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("registration")
    public String addNewUser(User user, Model model) {
        User newUser = userDao.findByUsername(user.getUsername());
        if (newUser != null) {
            model.addAttribute("userAddMessage", "User exist!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(new HashSet<>(Arrays.asList(Role.USER)));
        userDao.save(user);
        return "redirect:login";
    }
}
