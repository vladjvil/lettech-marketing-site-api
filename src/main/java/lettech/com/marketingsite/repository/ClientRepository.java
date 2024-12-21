package lettech.com.marketingsite.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import lettech.com.marketingsite.entity.Client;

import java.util.UUID;

@Repository
public interface ClientRepository extends CrudRepository<Client, UUID> {
}
