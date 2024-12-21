package lettech.com.marketingsite.service;

import lettech.com.marketingsite.dto.CreateSubscriberDto;
import lettech.com.marketingsite.entity.Subscriber;
import lettech.com.marketingsite.repository.SubscriberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriberService {
    private final SubscriberRepository subscriberRepository;

    public Subscriber createSubscriber(CreateSubscriberDto createSubscriberDto) {
        log.info("Saving subscriber with email: {}", createSubscriberDto.email());
        Subscriber subscriber = new Subscriber();
        subscriber.setEmail(createSubscriberDto.email());
        Subscriber savedSubscriber = subscriberRepository.save(subscriber);
        log.info("Subscriber saved successfully with ID: {}", savedSubscriber.getId());
        return savedSubscriber;
    }
}
