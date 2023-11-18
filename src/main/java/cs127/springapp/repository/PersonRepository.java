package cs127.springapp.repository;

import cs127.springapp.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> { // <Entity,Identifier
    Person findByPersonId(Long id);

    //custom query
    @Query(
            value = "SELECT * FROM PERSON WHERE LAST_NAME = ?1",
            nativeQuery = true
    ) // ?1 - dynamic argument 1
    Person findBySurname(String lastName);
}
