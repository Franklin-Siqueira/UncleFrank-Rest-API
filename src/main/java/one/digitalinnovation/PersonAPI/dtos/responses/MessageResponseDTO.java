package one.digitalinnovation.PersonAPI.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {
    private String message;
}
