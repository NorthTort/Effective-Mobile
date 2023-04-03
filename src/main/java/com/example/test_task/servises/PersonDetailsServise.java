package com.example.test_task.servises;

import com.example.test_task.repositories.PersonRepository;
import com.example.test_task.models.Person;
import com.example.test_task.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsServise implements UserDetailsService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonDetailsServise(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Person> person = personRepository.findByLogin(username);

        if(person.isEmpty()){
            throw  new UsernameNotFoundException("Пользователь не найден!");
        }

        return new PersonDetails(person.get());
    }
}
