package gr.hua.dit.ds.prent.Controllers;

import gr.hua.dit.ds.prent.Entities.Role;
import gr.hua.dit.ds.prent.Repositories.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {


    RoleRepository roleRepository;

    public AuthController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void setup() {
        Role role_tenant = new Role("ROLE_TENANT");
        Role role_owner = new Role("ROLE_OWNER");
        Role role_admin = new Role("ROLE_ADMIN");

        roleRepository.updateOrInsert(role_owner);
        roleRepository.updateOrInsert(role_admin);
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}
