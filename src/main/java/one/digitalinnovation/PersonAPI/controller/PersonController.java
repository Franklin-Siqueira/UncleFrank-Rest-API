package one.digitalinnovation.PersonAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    @GetMapping
    public String getBook(){
        return "REST API";
    }
//    private PersonService personService;
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
//        return personService.createPerson(personDTO);
//    }
//
//    @GetMapping
//    public List<PersonDTO> listAll() {
//        return personService.listAll();
//    }
//
//    @GetMapping("/{id}")
//    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
//        return personService.findById(id);
//    }
//
//    @PutMapping("/{id}")
//    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
//        return personService.updateById(id, personDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
//        personService.delete(id);
//    }
}

