package lettech.com.marketingsite.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CreateClientDto(
        @NotBlank(message = "Name cannot be blank")
        @Size(max = 100, message = "Name must not exceed 100 characters")
        String name,

        @Email(message = "Email should be valid")
        @Size(max = 100, message = "Email must not exceed 100 characters")
        String email,

        @Size(max = 500, message = "Project description must not exceed 500 characters")
        String projectDescription
) { }