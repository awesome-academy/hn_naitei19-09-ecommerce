package com.example.ecommerce.controller.user;
import com.example.ecommerce.DTO.UserLoginDto;
import com.example.ecommerce.dto.UserRegistrationDto;
import com.example.ecommerce.exeptions.LoginException;
import com.example.ecommerce.exeptions.RegistrationException;
import com.example.ecommerce.model.Role;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import org.apache.catalina.Session;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.SessionException;

@Controller
@SessionAttributes("user")
@RequestMapping(value="/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;
    @ModelAttribute("user")
    public UserLoginDto loginDto(){
        return new UserLoginDto();
    }

    @GetMapping
    public String getLoginForm(){
        return "user/auth/login";
    }
//
//    @PostMapping
//    public String login( @ModelAttribute("user")UserLoginDto loginDto, Model model) {
//        System.out.println(loginDto.getEmail());
//        User user = userService.login(loginDto);
//        try {
//            if (user != null) {
////                HttpSession session = request.getSession();
////                session.setAttribute("loggedInUser", user);
//                model.addAttribute("user", user);
//                return "redirect:/";
//            } else {
//                throw new LoginException("Your account or password incorrect");
//            }
//        } catch (LoginException e) {
//            model.addAttribute("loginError", e.getMessage());
//            return "user/auth/login";
//        }
//
//    }

}