package com.ecommerce.Ecommerce.Application.controller;

import com.ecommerce.Ecommerce.Application.model.Role;
import com.ecommerce.Ecommerce.Application.model.User;
import com.ecommerce.Ecommerce.Application.repository.RoleRepository;
import com.ecommerce.Ecommerce.Application.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class LoginController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginGet()
    {
        System.out.println("into login get method");

        //System.out.println(email+""+password);
        return "redirect:/";

    }

//    @PostMapping("/login")
//    public void loginPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String email = request.getParameter("email");
//        if(userRepository.findUserByEmail(email).isPresent())
//        {
//            response.sendRedirect("/");
//        }
//        else
//        {
//            response.sendRedirect("/register");
//        }
//    }

    @PostMapping("/login")
    public ModelAndView loginPost(@RequestParam("email") String email, @RequestParam("password") String password) {
        System.out.println("Into login post method");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        // Implement your authentication logic here.
        // If authentication is successful, redirect to the home page.
        // For example, you can use Spring Security to handle authentication.

        return new ModelAndView("redirect:/"); // Redirect to the home page after login.
    }


    @GetMapping("/register")
    public String registerget()
    {
        System.out.println("into regiser get method");
        return "register";
    }

    @PostMapping("/register")
    public void registerPost(@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("into register post method");
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(2).get());
        user.setRoles(roles);
        userRepository.save(user);
        //request.login(user.getEmail(),password);
        response.sendRedirect("/login");
    }

}
