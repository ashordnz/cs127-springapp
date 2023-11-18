package cs127.springapp.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs127.springapp.entity.Person;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddPersonRequest {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("middle_name")
    private String middleName;
    @JsonProperty("last_name")
    private String lastName;

    public Person mapToPerson() {
        return new Person(this.firstName, this.middleName, this.lastName);
    }
}
