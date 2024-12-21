package lettech.com.marketingsite.repository;

import lettech.com.marketingsite.entity.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, UUID> {
}
