package one.digitalinnovation.PersonAPI.repositories;

import one.digitalinnovation.PersonAPI.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
