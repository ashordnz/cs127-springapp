package cs127.springapp.repository;

import cs127.springapp.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> { // <Entity,Identifier>
    Person findByPersonId(Long id);
    //custom query
    @Query(
            value = "SELECT * FROM PERSON WHERE LAST_NAME = ?1",
            nativeQuery = true
    ) // ?1 - dynamic argument 1
    Person findBySurname(String lastName);
    void deletePersonByPersonId(Long personId);
//    @Query(
//            value = "UPDATE PERSON p SET p.firstname=?1, p.middleName=?2, p.lastName=?3 WHERE p.personId=?4",
//            nativeQuery = true
//    )
//    Person updatePerson(String firstName, String middlename, String lastName, Long personId);
}
