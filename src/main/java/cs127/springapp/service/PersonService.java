package cs127.springapp.service;

import cs127.springapp.entity.Person;
import cs127.springapp.entity.request.AddPersonRequest;
import cs127.springapp.entity.request.UpdatePersonRequest;

import java.util.List;

public interface PersonService {

    public List<Person> getAllPersons();
    public Person getPerson(Long id);
    public Person addPerson(AddPersonRequest personToAdd);

    public void deletePerson(Long personId);
    public Person getPersonBySurname(String surname);
    public Person updatePerson(Long personId, UpdatePersonRequest personToUpdate);
}
