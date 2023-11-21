package cs127.springapp.service;

import cs127.springapp.entity.Person;
import cs127.springapp.entity.request.AddPersonRequest;
import cs127.springapp.entity.request.UpdatePersonRequest;
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
    public Person getPerson(Long personId) {
        return personRepository.findByPersonId(personId);
    }

    @Override
    public Person addPerson(AddPersonRequest personToAdd) {
        return personRepository.save(personToAdd.mapToPerson()); // for adding person with all fields included
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deletePersonByPersonId(personId);
    }

    @Override
    public List<Person> getPersonsBySurname(String surname) {
        return personRepository.findBySurname(surname);
    }

    @Override
    public Person updatePerson(Long personId, UpdatePersonRequest personToUpdate) {
        Person person = getPerson(personId);

        if(personToUpdate.getFirstName() != null) {
            person.setFirstName(personToUpdate.getFirstName());
        }

        if(personToUpdate.getMiddleName() != null) {
            person.setMiddleName(personToUpdate.getMiddleName());
        }

        if(personToUpdate.getLastName() != null) {
            person.setLastName(personToUpdate.getLastName());
        }

        return personRepository.save(person);
    }
}
