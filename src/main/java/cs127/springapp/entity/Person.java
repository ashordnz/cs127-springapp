package cs127.springapp.entity;

import cs127.springapp.entity.request.AddPersonRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "PERSON") // table name in db
@RequiredArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(generator = "person_seq")
    @SequenceGenerator(name = "person_seq", sequenceName = "PERSON_SEQ", allocationSize = 1) // alloc size = increment count
    private long personId;
    private String firstName;
    private String middleName;
    private String lastName;

    public Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}
