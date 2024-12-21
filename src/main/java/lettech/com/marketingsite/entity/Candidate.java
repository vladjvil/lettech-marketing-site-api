package lettech.com.marketingsite.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "candidates")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String position;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String experience;

    @Lob
    @Column(nullable = false)
    private byte[] cv;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;
}
