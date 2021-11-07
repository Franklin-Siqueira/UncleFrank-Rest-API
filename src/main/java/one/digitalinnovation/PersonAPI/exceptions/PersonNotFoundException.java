package one.digitalinnovation.PersonAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {
    /**
     *
     * @param id
     */
    public PersonNotFoundException(Long id) {
        super("Person not found with ID " + id);
    }
}
