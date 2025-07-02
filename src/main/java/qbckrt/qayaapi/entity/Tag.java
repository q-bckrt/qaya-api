package qbckrt.qayaapi.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "tags")
public class Tag {

    // FIELDS
    @Id
    private UUID id;
    @Column(name="label", nullable = false)
    private String label;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    @Column(name="created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name="updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name="is_deleted", nullable = false)
    private boolean isDeleted;

    // CONSTRUCTORS
    public Tag() {}
    public Tag(String label, User user) {
        this.id = UUID.randomUUID();
        this.label = label;
        this.user = user;
        this.isDeleted = false;
    }
}
