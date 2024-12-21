package lettech.com.marketingsite.controller;

import lettech.com.marketingsite.dto.CreateCandidateDto;
import lettech.com.marketingsite.entity.Candidate;
import lettech.com.marketingsite.service.CandidateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Candidate> create(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("position") String position,
            @RequestParam("experience") String experience,
            @RequestParam("cv") MultipartFile cv) {
        log.info("Caught request to create candidate");

        Candidate createdCandidate = candidateService.createCandidate(
                CreateCandidateDto.builder()
                        .name(name)
                        .email(email)
                        .position(position)
                        .experience(experience)
                        .cv(cv)
                        .build()
        );
        return new ResponseEntity<>(createdCandidate, HttpStatus.CREATED);
    }
}
