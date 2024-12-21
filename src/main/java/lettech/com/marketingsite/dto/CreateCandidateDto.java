package lettech.com.marketingsite.dto;

import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record CreateCandidateDto(
        String name,
        String email,
        String position,
        String experience,
        MultipartFile cv
) { }
