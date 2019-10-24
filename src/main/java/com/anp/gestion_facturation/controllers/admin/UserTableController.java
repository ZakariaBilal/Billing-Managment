package com.anp.gestion_facturation.controllers.admin;

import com.anp.gestion_facturation.model.dao.PortRepo;
import com.anp.gestion_facturation.model.dao.UserRepo;
import com.anp.gestion_facturation.model.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserTableController
 */
@Controller
@RequestMapping("/admin")
public class UserTableController {

    private UserRepo userRepo;
    private PortRepo portRepo;

    @Autowired
    public UserTableController(UserRepo userRepo, PortRepo portRepo) {
        this.userRepo = userRepo;
        this.portRepo = portRepo;
    }

    @GetMapping(value = "/users")
    public String displayUserTable(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "/admin/users";
    }

    @GetMapping(value = "/users/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("ports", portRepo.findAll());
        return "/admin/addUser";
    }

    @PostMapping(value = "/users")
    public String addUser(@ModelAttribute User user) {
        BCryptPasswordEncoder pEncoder = new BCryptPasswordEncoder();
        user.setPassword(pEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userRepo.deleteById(userId);
        return "redirect:/admin/users";
    }
}