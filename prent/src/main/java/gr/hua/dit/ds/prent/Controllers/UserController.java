package gr.hua.dit.ds.prent.Controllers;

import gr.hua.dit.ds.prent.Entities.User;
import gr.hua.dit.ds.prent.Repositories.RoleRepository;

import gr.hua.dit.ds.prent.Repositories.UserRepository;
import gr.hua.dit.ds.prent.Services.UserDetailsImpl;
import gr.hua.dit.ds.prent.Services.UserDetailsServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserDetailsServiceImpl userService;

    private RoleRepository roleRepository;

    private UserRepository userRepository;

    public UserController(UserDetailsServiceImpl userService, RoleRepository roleRepository, UserRepository userRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "auth/register";
    }

    @PostMapping("/saveTenant")
    public String saveTenant(@ModelAttribute User tenant, Model model){
        Long id = userService.saveTenant(tenant);
        String message = "Tenant '"+id+"' saved successfully !";
        model.addAttribute("msg", message);
        return "index";
    }

    @PostMapping("/saveOwner")
    public String saveOwner(@ModelAttribute User owner, Model model){
        Long id = userService.saveOwner(owner);
        String message = "Owner '"+id+"' saved successfully !";
        model.addAttribute("msg", message);
        return "index";
    }

    @PostMapping("/user/{user_id}")
    public String saveUser(@PathVariable Long user_id, @ModelAttribute("user") User user, Model model) {
        User the_user = (User) userService.getUser(user_id);
        the_user.setE_mail(user.getE_mail());
        the_user.setUsername(user.getUsername());
        userService.updateUser(the_user);
        model.addAttribute("users", userService.getUsers());
        return "auth/users";
    }

    @GetMapping("/users")
    public String showUsers(Model model){
        if (!userRepository.findAll().isEmpty())
            model.addAttribute("users", userService.getUsers());
        else
            model.addAttribute("msg", "No users found!");
        return "auth/users";
    }

    @GetMapping("/user/{user_id}")
    public String showUser(@PathVariable Long user_id, Model model){
        var existing = userRepository.findById(user_id).orElse(null);
        if (existing != null)
            model.addAttribute("user", userService.getUser(user_id));
        else
            model.addAttribute("msg", "User not found!");
        return "auth/user";
    }

    @PostMapping("/myprofile")
    public String MyProfile(@PathVariable Model model, @AuthenticationPrincipal UserDetailsImpl auth){
        model.addAttribute("user", userService.getUser(auth.getId()));
        return "";
    }


}
