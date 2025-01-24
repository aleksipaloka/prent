package gr.hua.dit.ds.prent.Services;

import gr.hua.dit.ds.prent.Entities.Role;
import gr.hua.dit.ds.prent.Entities.User;
import gr.hua.dit.ds.prent.Repositories.RoleRepository;
import gr.hua.dit.ds.prent.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {


    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Long saveOwner(User owner) {
        String passwd= owner.getPersonalPW();
        String encodedPassword = passwordEncoder.encode(passwd);
        owner.setPersonalPW(encodedPassword);

        Role ownerrole = roleRepository.findByName("ROLE_OWNER")
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Set<Role> roles = new HashSet<>();
        roles.add(ownerrole);
        owner.setRoles(roles);

        owner = userRepository.save(owner);
        return owner.getId();
    }

    @Transactional
    public Long saveTenant(User tenant) {
        String passwd= tenant.getPersonalPW();
        String encodedPassword = passwordEncoder.encode(passwd);
        tenant.setPersonalPW(encodedPassword);

        Role tenantrole = roleRepository.findByName("ROLE_TENANT")
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Set<Role> roles = new HashSet<>();
        roles.add(tenantrole);
        tenant.setRoles(roles);

        tenant = userRepository.save(tenant);
        return tenant.getId();
    }

    @Transactional
    public Long updateUser(User user) {
        user = userRepository.save(user);
        return user.getId();
    }
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = userRepository.findByUsername(username);

        if(opt.isEmpty())
            throw new UsernameNotFoundException("User with email: " +username +" not found !");
        else {
            User user = opt.get();
            return new org.springframework.security.core.userdetails.User(
                    user.getE_mail(),
                    user.getPersonalPW(),
                    user.getRoles()
                            .stream()
                            .map(role-> new SimpleGrantedAuthority(role.toString()))
                            .collect(Collectors.toSet())
            );
        }
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
