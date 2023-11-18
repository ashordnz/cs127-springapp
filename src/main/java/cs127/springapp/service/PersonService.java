package cs127.springapp.service;

import cs127.springapp.entity.Person;
import cs127.springapp.entity.request.AddPersonRequest;

import java.util.List;

public interface PersonService {

    public List<Person> getAllPersons();
    public Person getPerson(Long id);
    public Person addPerson(AddPersonRequest personToAdd);
}
