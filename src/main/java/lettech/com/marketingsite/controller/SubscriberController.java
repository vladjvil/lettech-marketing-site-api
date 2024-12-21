package lettech.com.marketingsite.controller;

import lettech.com.marketingsite.dto.CreateSubscriberDto;
import lettech.com.marketingsite.entity.Subscriber;
import lettech.com.marketingsite.service.SubscriberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/subscribers")
@RequiredArgsConstructor
public class SubscriberController {
    private final SubscriberService subscriberService;

    @PostMapping
    public ResponseEntity<Subscriber> createSubscriber(@RequestBody CreateSubscriberDto createSubscriberDto) {
        log.info("Caught request to create subscriber");
        Subscriber createdSubscriber = subscriberService.createSubscriber(createSubscriberDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubscriber);
    }
}
