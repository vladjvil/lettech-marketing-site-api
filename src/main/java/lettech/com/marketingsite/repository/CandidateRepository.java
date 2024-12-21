package lettech.com.marketingsite.repository;

import lettech.com.marketingsite.entity.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, UUID> {
}
