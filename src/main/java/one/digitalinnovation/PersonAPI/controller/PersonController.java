package one.digitalinnovation.PersonAPI.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.PersonAPI.dtos.requests.PersonDto;
import one.digitalinnovation.PersonAPI.dtos.responses.MessageResponseDTO;
import one.digitalinnovation.PersonAPI.entities.Person;
import one.digitalinnovation.PersonAPI.exceptions.PersonNotFoundException;
import one.digitalinnovation.PersonAPI.repositories.PersonRepository;
import one.digitalinnovation.PersonAPI.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
//
//    @GetMapping
//    public String getPersonRestAPI(){
//        return "REST API";
//    }
//
//    private PersonRepository personRepository;
//
//    @Autowired
//    public PersonController(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//
//    @PostMapping
//    public MessageResponseDTO createPerson(@RequestBody Person person){
//      Person savedPerson = personRepository.save(person);
//        return MessageResponseDTO
//                .builder()
//                .message("Created person with Id: " + savedPerson.getId())
//                .build();
//    }
//
    private PersonService personService;

    /**
     *
     * @param personDTO
     * @return
     *
     * Sample (use on Postman):
     * {
     *     "firstName": "Franklin",
     *     "lastName": "Siqueira",
     *     "birthDate": "10-10-2000",
     *     "cpf": "267.450.589-36",
     *     "phones": [
     *         {
     *             "id": "1",
     *             "type": "MOBILE",
     *             "number": "(11)999990000"
     *         }
     *     ]
     * }
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDto personDTO) {
        return personService.createPerson(personDTO);
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<PersonDto> listAll() {
        return personService.listAll();
    }

    /**
     * Mark: TEXT ADDED ON newFeatures BRANCH
     *
     * @param id
     * @return
     * @throws PersonNotFoundException
     */
    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    /**
     *
     * @param id
     * @param personDTO
     * @return
     * @throws PersonNotFoundException
     *
     * Sample (use on Postman):
     * {
     *     "id": 1,
     *     "firstName": "Franklin",
     *     "lastName": "Siqueira",
     *     "birthDate": "10-10-2000",
     *     "cpf": "267.450.589-36",
     *     "phones": [
     *         {
     *             "id": 1,
     *             "type": "MOBILE",
     *             "number": "(11)999990000"
     *         }
     *     ]
     * }
     */
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDto personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }

    /**
     *
     * @param id
     * @throws PersonNotFoundException
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}

