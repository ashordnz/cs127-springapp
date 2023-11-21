package cs127.springapp.controller;

import cs127.springapp.entity.Person;
import cs127.springapp.entity.request.AddPersonRequest;
import cs127.springapp.entity.request.UpdatePersonRequest;
import cs127.springapp.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// controllers - endpoint definitions
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/person")
public class PersonController {

    private final PersonService personService; // automatically finds a class that implements this interface.

    @GetMapping(path = "/all")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(path = "/{personId}")
    public Person getPerson(@PathVariable Long personId) {
        return personService.getPerson(personId);
    }

    @PostMapping(path = "/add")
    public @ResponseBody Person addPerson(@RequestBody AddPersonRequest personToAdd) {
        return personService.addPerson(personToAdd);
    }

    @Transactional
    @DeleteMapping(path = "/delete/{personId}")
    public String deletePerson(@PathVariable Long personId) {
        personService.deletePerson(personId);
        return "Person with id " + personId + " was successfully removed.";
    }

    @GetMapping(path = "/surname/{lastName}")
    public List<Person> getPersonsBySurname(@PathVariable String lastName) {
        return personService.getPersonsBySurname(lastName);
    }

    @PatchMapping(path = "/update/{personId}")
    public Person updatePerson(@PathVariable Long personId, @RequestBody UpdatePersonRequest personToUpdate) {
        return personService.updatePerson(personId, personToUpdate);
    }

}
