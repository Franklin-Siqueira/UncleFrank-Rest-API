package one.digitalinnovation.PersonAPI.services;

import lombok.AllArgsConstructor;
import one.digitalinnovation.PersonAPI.dtos.requests.PersonDto;
import one.digitalinnovation.PersonAPI.dtos.responses.MessageResponseDTO;
import one.digitalinnovation.PersonAPI.entities.Person;
import one.digitalinnovation.PersonAPI.exceptions.PersonNotFoundException;
import one.digitalinnovation.PersonAPI.mappers.PersonMapper;
import one.digitalinnovation.PersonAPI.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    /**
     *
     * @title createPerson()
     *  add a new Person to DB
     * @param personDTO
     * @return
     */
    public MessageResponseDTO createPerson(PersonDto personDTO) {

        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);

        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    /**
     *
     * @return
     */
    public List<PersonDto> listAll() {

        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param id
     * @return
     * @throws PersonNotFoundException
     */
    public PersonDto findById(Long id) throws PersonNotFoundException {

        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }

    /**
     *
     * @param id
     * @throws PersonNotFoundException
     */
    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    /**
     *
     * @param id
     * @param personDTO
     * @return
     * @throws PersonNotFoundException
     */
    public MessageResponseDTO updateById(Long id, PersonDto personDTO) throws PersonNotFoundException {

        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personToUpdate);

        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
    }

    /**
     *
     * @param id
     * @return
     * @throws PersonNotFoundException
     */
    private Person verifyIfExists(Long id) throws PersonNotFoundException {

        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    /**
     *
     * @param id
     * @param message
     * @return
     */
    private MessageResponseDTO createMessageResponse(Long id, String message) {

        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}

