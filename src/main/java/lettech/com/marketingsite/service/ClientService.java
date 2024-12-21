package lettech.com.marketingsite.service;

import lettech.com.marketingsite.dto.CreateClientDto;
import lettech.com.marketingsite.entity.Client;
import lettech.com.marketingsite.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client createClient(CreateClientDto createClientDto) {
        log.info("Saving client with name: {}", createClientDto.name());
        Client client = Client.builder()
                .name(createClientDto.name())
                .email(createClientDto.email())
                .projectDescription(createClientDto.projectDescription())
                .build();
        Client savedClient = clientRepository.save(client);
        log.info("Client saved successfully with ID: {}", savedClient.getId());
        return savedClient;
    }

}
