package lettech.com.marketingsite.controller;

import lettech.com.marketingsite.dto.CreateClientDto;
import lettech.com.marketingsite.entity.Client;
import lettech.com.marketingsite.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createSubscriber(@RequestBody CreateClientDto createClientDto) {
        log.info("Caught request to create client");
        Client createdClient = clientService.createClient(createClientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }
}
