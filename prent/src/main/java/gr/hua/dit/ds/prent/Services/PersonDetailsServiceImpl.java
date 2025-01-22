package gr.hua.dit.ds.prent.Services;

import gr.hua.dit.ds.prent.Entities.Person;
import gr.hua.dit.ds.prent.Entities.Role;
import gr.hua.dit.ds.prent.Repositories.PersonRepository;
import gr.hua.dit.ds.prent.Repositories.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PersonDetailsServiceImpl  {

    private PersonRepository personRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public PersonDetailsServiceImpl(PersonRepository personRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserDetails loadPersonByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> opt = personRepository.findByUsername(username);

        if(opt.isEmpty())
            throw new UsernameNotFoundException("User with username: " +username +" not found !");
        else {
            Person person = opt.get();

            return PersonDetailsImpl.build(person);
        }
    }



    @Transactional
    public Integer saveUser(Person person) {
        String passwd= person.getPersonalPW();
        String encodedPassword = passwordEncoder.encode(passwd);
        person.setPersonalPW(encodedPassword);

        Role role = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        person.setRole(role);

        person = personRepository.save(person);
        return person.getSysPersonID();
    }

    @Transactional
    public Integer updatePerson(Person person) {
        person = personRepository.save(person);
        return person.getSysPersonID();
    }

    @Transactional
    public Object getPersons() {
        return personRepository.findAll();
    }

    public Object getPerson(Integer personId) {
        return personRepository.findById(personId).get();
    }

    @Transactional
    public void updateOrInsertRole(Role role) {
        roleRepository.updateOrInsert(role);
    }

}
