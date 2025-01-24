//package gr.hua.dit.ds.prent.Services;
//
//import gr.hua.dit.ds.prent.Entities.User;
//import gr.hua.dit.ds.prent.Entities.Role;
//import gr.hua.dit.ds.prent.Entities.User;
//import gr.hua.dit.ds.prent.Repositories.UserRepository;
//import gr.hua.dit.ds.prent.Repositories.RoleRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//public class UserDetailsServiceImpl {
//
//    private UserRepository userRepository;
//    private RoleRepository roleRepository;
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> opt = userRepository.findByUsername(username);
//
//        if(opt.isEmpty())
//            throw new UsernameNotFoundException("User with username: " +username +" not found !");
//        else {
//            User user = opt.get();
//
//            return UserDetailsImpl.build(user);
//        }
//    }
//
//
//
//    @Transactional
//    public Long saveTenant(User tenant) {
//        String passwd= tenant.getPersonalPW();
//        String encodedPassword = passwordEncoder.encode(passwd);
//        tenant.setPersonalPW(encodedPassword);
//
//        Role role = roleRepository.findByName("ROLE_TENANT")
//                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleRepository.updateOrInsert(new Role("ROLE_TENANT")));
//        tenant.setRoles(roles);
//
//        tenant = userRepository.save(tenant);
//        return tenant.getId();
//    }
//
//    @Transactional
//    public Long saveOwner(User owner) {
//        String passwd= owner.getPersonalPW();
//        String encodedPassword = passwordEncoder.encode(passwd);
//        owner.setPersonalPW(encodedPassword);
//
//        Role role = roleRepository.findByName("ROLE_OWNER")
//                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleRepository.updateOrInsert(new Role("ROLE_OWNER")));
//        owner.setRoles(roles);
//
//        owner = userRepository.save(owner);
//        return owner.getId();
//    }
//
//    @Transactional
//    public Long updateUser(User user) {
//        user = userRepository.save(user);
//        return user.getId();
//    }
//
//    @Transactional
//    public Object getUsers() {
//        return userRepository.findAll();
//    }
//
//    public Object getUser(Long userId) {
//        return userRepository.findById(userId).get();
//    }
//
//    @Transactional
//    public void updateOrInsertRole(Role role) {
//        roleRepository.updateOrInsert(role);
//    }
//
//}
