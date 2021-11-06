package one.digitalinnovation.PersonAPI.mappers;

import one.digitalinnovation.PersonAPI.dtos.requests.PersonDto;
import one.digitalinnovation.PersonAPI.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDto personDTO);
    PersonDto toDTO(Person person);
    // DTO -> Data Transfer Object
}
