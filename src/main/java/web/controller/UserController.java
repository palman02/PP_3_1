package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.ServiceUser;


@Controller
public class UserController {

    private final ServiceUser serviceUser;

    @Autowired
    public UserController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping()
    public String showAllUser(Model model) {
        model.addAttribute("users", serviceUser.findAll());
        return "/showAllUsers";
    }

    @GetMapping("/{id}")
    public String showOneUser(@PathVariable int id, Model model) {
        model.addAttribute("user", serviceUser.findOne(id));
        return "/showOneUser";
    }


    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "/newUser";
    }

    @PostMapping()
    public String createUser(@ModelAttribute User user) {
        serviceUser.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", serviceUser.findOne(id));
        return "/editUser";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable int id) {
        serviceUser.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        serviceUser.deleteUser(id);
        return "redirect:/";
    }
}
