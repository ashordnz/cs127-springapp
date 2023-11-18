package cs127.springapp.service;

import cs127.springapp.entity.Person;
import cs127.springapp.entity.request.AddPersonRequest;
import cs127.springapp.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// services - business logic
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPerson(Long id) {
        return personRepository.findByPersonId(id);
    }

    @Override
    public Person addPerson(AddPersonRequest personToAdd) {
        return personRepository.save(personToAdd.mapToPerson()); // for adding person with all fields included
    }
}
