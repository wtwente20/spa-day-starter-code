package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

//    In the UserController, create a handler method displayAddUserForm() to render the form.
//    This handler should correspond to the path /user/add, and for now, it can just return
//    the path to the add.html template.

    @GetMapping("/add")
    public String displayAddUserForm() {
        return "/user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("user", user);
        model.addAttribute("verify", verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        if (user.getPassword().equals(verify)) {
            return "/user/index";
        } else {
            model.addAttribute("error", "Passwords do not match!");
            return "/user/add";
        }
        // add form submission handling code here
    }


}
