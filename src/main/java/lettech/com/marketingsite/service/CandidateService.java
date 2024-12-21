package lettech.com.marketingsite.service;

import lettech.com.marketingsite.dto.CreateCandidateDto;
import lettech.com.marketingsite.entity.Candidate;
import lettech.com.marketingsite.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;

    @Transactional
    public Candidate createCandidate(CreateCandidateDto createCandidateDto) {
        log.info("Executing candidate creation with name: {}, email: {}, position: {}",
                createCandidateDto.name(), createCandidateDto.email(), createCandidateDto.position());

        Candidate candidate = Candidate.builder()
                .name(createCandidateDto.name())
                .email(createCandidateDto.email())
                .position(createCandidateDto.position())
                .experience(createCandidateDto.experience())
                .build();

        MultipartFile cvFile = createCandidateDto.cv();
        if (cvFile != null && !cvFile.isEmpty()) {
            try {
                if (!"application/pdf".equals(cvFile.getContentType())) {
                    log.error("Invalid CV content type: {}. Only PDF is allowed.", cvFile.getContentType());
                    throw new IllegalArgumentException("CV must be a PDF file.");
                }
                candidate.setCv(cvFile.getBytes());
                log.info("CV file processed successfully for candidate: {}", createCandidateDto.name());
            } catch (IOException e) {
                log.error("Failed to read CV file for candidate: {}", createCandidateDto.name(), e);
                throw new RuntimeException("Failed to read CV file", e);
            }
        } else {
            log.error("CV file is missing for candidate: {}", createCandidateDto.name());
            throw new IllegalArgumentException("CV file is required.");
        }

        Candidate savedCandidate = candidateRepository.save(candidate);
        log.info("Candidate saved successfully with ID: {}", savedCandidate.getId());

        return savedCandidate;
    }
}
