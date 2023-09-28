package com.example.ecommerce.controller.admin;


import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/users")
public class UsersController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String listOrders(Model model,
                             @RequestParam(defaultValue = "") String fullname,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "7") int size) {
        Page<User> userPage;

        userPage = userService.searchByFullname(fullname, page, size, "fullname", "asc");

        model.addAttribute("usersPage", userPage);
        model.addAttribute("users", userPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("fullname", fullname);

        return "admin/users/index";
    }

    @PostMapping("/activate-user/{id}")
    public String activateUser(@PathVariable Long id) {
        userService.activateUser(id);
        return "redirect:/admin/users/";
    }

    @PostMapping("/deactivate-user/{id}")
    public String deactivateUser(@PathVariable Long id) {
        userService.deactivateUser(id);
        return "redirect:/admin/users/";
    }


}
