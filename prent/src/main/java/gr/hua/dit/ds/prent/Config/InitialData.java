package gr.hua.dit.ds.prent.Config;

import gr.hua.dit.ds.prent.Entities.Ad;
import gr.hua.dit.ds.prent.Entities.Person;
import gr.hua.dit.ds.prent.Entities.Property;
import gr.hua.dit.ds.prent.Entities.Role;
import gr.hua.dit.ds.prent.Repositories.AdRepository;
import gr.hua.dit.ds.prent.Repositories.PersonRepository;
import gr.hua.dit.ds.prent.Repositories.PropertyRepository;
import gr.hua.dit.ds.prent.Repositories.RoleRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Configuration
public class InitialData {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitialData.class);

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdRepository adRepository;
    private final PropertyRepository propertyRepository;

    public InitialData(PersonRepository personRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder,
                       AdRepository adRepository,
                       PropertyRepository propertyRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.adRepository = adRepository;
        this.propertyRepository = propertyRepository;
    }

    @Transactional
    @PostConstruct
    public void populateDBWithInitialData() {
        this.roleRepository.deleteAll();
        this.personRepository.deleteAll();
        this.adRepository.deleteAll();
        this.propertyRepository.deleteAll();

        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleTenant = new Role("ROLE_TENANT");
        Role roleOwner = new Role("ROLE_OWNER");

        roleAdmin = this.roleRepository.updateOrInsert(roleAdmin);
        roleTenant = this.roleRepository.updateOrInsert(roleTenant);
        roleOwner = this.roleRepository.updateOrInsert(roleOwner);

        var existing = this.personRepository.findByUsername("admin").orElse(null);
        if (existing == null) {
            LOGGER.info("Creating User 'admin'");
            Person personAdmin = new Person();
            personAdmin.setUsername("admin");
            personAdmin.setPersonalPW(this.passwordEncoder.encode("admin"));
            personAdmin.setE_mail("admin@hua.gr");
            personAdmin.setRole(roleAdmin);
            this.personRepository.save(personAdmin);
        }

        existing = this.personRepository.findByUsername("manager").orElse(null);
        if (existing == null) {
            LOGGER.info("Creating User 'tenant'");
            Person personTenant = new Person();
            personTenant.setUsername("tenant");
            personTenant.setPersonalPW(this.passwordEncoder.encode("tenant"));
            personTenant.setE_mail("tenant@hua.gr");
            personTenant.setRole(roleTenant);
            this.personRepository.save(personTenant);
        }

        existing = this.personRepository.findByUsername("owner").orElse(null);
        if (existing == null) {
            LOGGER.info("Creating User 'owner'");
            Person personOwner = new Person();
            personOwner.setUsername("owner");
            personOwner.setPersonalPW(this.passwordEncoder.encode("owner"));
            personOwner.setE_mail("user@hua.gr");
            personOwner.setRole(roleOwner);
            this.personRepository.save(personOwner);
        }

        var defaultProperty = this.propertyRepository.findById(1).orElse(null);
        if (defaultProperty == null) {
            defaultProperty = new Property();
            defaultProperty.setPrice(100000.00);
            defaultProperty.setLocation("Athens");
            defaultProperty.setSize(162.00);
            defaultProperty.setProperty_Type("Building");
            defaultProperty.setOwner(this.personRepository.findByUsername("owner").orElse(null));
            defaultProperty = this.propertyRepository.save(defaultProperty);
        }

        var defaultad = this.adRepository.findById(1).orElse(null);
        if (defaultad == null) {
            defaultad = new Ad();
            defaultad.setContact_Number("6969696969");
            defaultad.setRelease_Date(Date.valueOf(LocalDate.now()));
            defaultad.setLast_Update(Date.valueOf(LocalDate.now()));
            defaultad.setProperty(defaultProperty);
            defaultad = this.adRepository.save(defaultad);
        }


    }
}
