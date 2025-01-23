package gr.hua.dit.ds.prent.Services;

import gr.hua.dit.ds.prent.Entities.User;
import gr.hua.dit.ds.prent.Entities.Role;
import gr.hua.dit.ds.prent.Entities.User;
import gr.hua.dit.ds.prent.Repositories.UserRepository;
import gr.hua.dit.ds.prent.Repositories.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class UserDetailsServiceImpl {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserDetails loadPersonByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = userRepository.findByUsername(username);

        if(opt.isEmpty())
            throw new UsernameNotFoundException("User with username: " +username +" not found !");
        else {
            User user = opt.get();

            return UserDetailsImpl.build(user);
        }
    }



    @Transactional
    public Long saveUser(User user) {
        String passwd= user.getPersonalPW();
        String encodedPassword = passwordEncoder.encode(passwd);
        user.setPersonalPW(encodedPassword);

        Role role = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        user.setRole(role);

        user = userRepository.save(user);
        return user.getId();
    }

    @Transactional
    public Long updateUser(User user) {
        user = userRepository.save(user);
        return user.getId();
    }

    @Transactional
    public Object getUsers() {
        return userRepository.findAll();
    }

    public Object getUser(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Transactional
    public void updateOrInsertRole(Role role) {
        roleRepository.updateOrInsert(role);
    }

}
