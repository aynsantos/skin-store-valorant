package com.scoder.admin.controller;


import com.scoder.library.dto.AdminDTO;
import com.scoder.library.model.Admin;
import com.scoder.library.service.impl.AdminServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/login")
    public String LoginForm() {
        return "login";
    }

    @RequestMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("adminDTO", new AdminDTO());
        return "register";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(Model model) {
        return "forgot-password";
    }

    @PostMapping("/register-new")
    @Transactional
    public String addNewAdmin(@Valid @ModelAttribute("adminDTO")AdminDTO adminDTO,
                              BindingResult result,
                              Model model){



        try {

            if(result.hasErrors()){
                model.addAttribute("adminDTO", adminDTO);
                result.toString();
                return "register";
            }
            String username = adminDTO.getUsername();
            Admin admin = adminServiceImpl.findByUsername(username);
            if(admin != null){
                model.addAttribute("adminDTO", adminDTO);
                System.out.println("Admin não pode ser nulo!");
                model.addAttribute("emailError", "Seu e-mail foi registrado!");
                return "register";
            }
            if(adminDTO.getPassword().equals(adminDTO.getConfirmPassword())){
                adminDTO.setPassword(bCryptPasswordEncoder.encode(adminDTO.getPassword()));
                adminServiceImpl.save(adminDTO);
                System.out.println("success");
                model.addAttribute("success", "Registrado com sucesso!");
                model.addAttribute("adminDTO", adminDTO);
            }else{
                model.addAttribute("adminDTO", adminDTO);
                model.addAttribute("passwordError", "Seu password deve ser mais forte! Verifique e tente novamente!");
                System.out.println("Password não é o mesmo");
                return "register";
            }
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("errors", "Server error!");
        }
        return "register";

    }

}
