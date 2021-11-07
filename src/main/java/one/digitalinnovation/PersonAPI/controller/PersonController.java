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
//
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDto personDTO) {
        return personService.createPerson(personDTO);
    }
//
    @GetMapping
    public List<PersonDto> listAll() {
        return personService.listAll();
    }
//
    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }
//
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDto personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }
//
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}

