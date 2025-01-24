//package gr.hua.dit.ds.prent.Config;
//
//import gr.hua.dit.ds.prent.Entities.Ad;
//import gr.hua.dit.ds.prent.Entities.User;
//import gr.hua.dit.ds.prent.Entities.Property;
//import gr.hua.dit.ds.prent.Entities.Role;
//import gr.hua.dit.ds.prent.Repositories.AdRepository;
//import gr.hua.dit.ds.prent.Repositories.UserRepository;
//import gr.hua.dit.ds.prent.Repositories.PropertyRepository;
//import gr.hua.dit.ds.prent.Repositories.RoleRepository;
//import jakarta.annotation.PostConstruct;
//import jakarta.transaction.Transactional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Set;
//
//@Configuration
//public class InitialData {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(InitialData.class);
//
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final AdRepository adRepository;
//    private final PropertyRepository propertyRepository;
//
//    public InitialData(UserRepository userRepository,
//                       RoleRepository roleRepository,
//                       PasswordEncoder passwordEncoder,
//                       AdRepository adRepository,
//                       PropertyRepository propertyRepository) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.adRepository = adRepository;
//        this.propertyRepository = propertyRepository;
//    }
//
//    @Transactional
//    @PostConstruct
//    public void populateDBWithInitialData() {
//        this.roleRepository.deleteAll();
//        this.userRepository.deleteAll();
//        this.adRepository.deleteAll();
//        this.propertyRepository.deleteAll();
//
//        Role roleAdmin = new Role("ROLE_ADMIN");
//        Role roleTenant = new Role("ROLE_TENANT");
//        Role roleOwner = new Role("ROLE_OWNER");
//
//        roleAdmin = this.roleRepository.updateOrInsert(roleAdmin);
//        roleTenant = this.roleRepository.updateOrInsert(roleTenant);
//        roleOwner = this.roleRepository.updateOrInsert(roleOwner);
//
//        var existing = this.userRepository.findByUsername("admin").orElse(null);
//        if (existing == null) {
//            LOGGER.info("Creating User 'admin'");
//            User userAdmin = new User();
//            userAdmin.setUsername("admin");
//            userAdmin.setPersonalPW(this.passwordEncoder.encode("admin"));
//            userAdmin.setE_mail("admin@hua.gr");
//            Set<Role> roles = new HashSet<>();
//            roles.add(roleAdmin);
//            roles.add(roleOwner);
//            roles.add(roleTenant);
//            userAdmin.setRoles(roles);
//            this.userRepository.save(userAdmin);
//        }
//
//        existing = this.userRepository.findByUsername("manager").orElse(null);
//        if (existing == null) {
//            LOGGER.info("Creating User 'tenant'");
//            User userTenant = new User();
//            userTenant.setUsername("tenant");
//            userTenant.setPersonalPW(this.passwordEncoder.encode("tenant"));
//            userTenant.setE_mail("tenant@hua.gr");
//            Set<Role> roles = new HashSet<>();
//            roles.add(roleTenant);
//            userTenant.setRoles(roles);
//
//            this.userRepository.save(userTenant);
//        }
//
//        existing = this.userRepository.findByUsername("owner").orElse(null);
//        if (existing == null) {
//            LOGGER.info("Creating User 'owner'");
//            User userOwner = new User();
//            userOwner.setUsername("owner");
//            userOwner.setPersonalPW(this.passwordEncoder.encode("owner"));
//            userOwner.setE_mail("user@hua.gr");
//            Set<Role> roles = new HashSet<>();
//            roles.add(roleOwner);
//            userOwner.setRoles(roles);
//            this.userRepository.save(userOwner);
//        }
//
//        var defaultProperty = this.propertyRepository.findById(1L).orElse(null);
//        if (defaultProperty == null) {
//            defaultProperty = new Property();
//            defaultProperty.setPrice(100000.00);
//            defaultProperty.setLocation("Athens");
//            defaultProperty.setSize(162.00);
//            defaultProperty.setProperty_Type("Building");
//            defaultProperty.setOwner(this.userRepository.findByUsername("owner").orElse(null));
//            defaultProperty = this.propertyRepository.save(defaultProperty);
//        }
//
//        var defaultad = this.adRepository.findById(1L).orElse(null);
//        if (defaultad == null) {
//            defaultad = new Ad();
//            defaultad.setContact_Number("6969696969");
//            defaultad.setRelease_Date(Date.valueOf(LocalDate.now()));
//            defaultad.setLast_Update(Date.valueOf(LocalDate.now()));
//            defaultad.setProperty(defaultProperty);
//            defaultad = this.adRepository.save(defaultad);
//        }
//
//
//    }
//}
