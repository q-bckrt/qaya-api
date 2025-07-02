package qbckrt.qayaapi.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import qbckrt.qayaapi.enums.CategoryType;
import qbckrt.qayaapi.enums.TransactionType;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "categories")
public class Category {

    // FIELDS
    @Id
    private UUID id;
    @Column(name = "label", nullable = false)
    private String label;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CategoryType type;
    @Column(name = "icon_key", nullable = false)
    private String iconKey;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    // CONSTRUCTORS
    public Category(){}
    public Category(String label, String description, CategoryType transactionType, String iconKey, User user) {
        this.id = UUID.randomUUID();

        this.label = label;
        this.description = description;
        this.type = transactionType;
        this.iconKey = iconKey;
        this.userId = user;

        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.isDeleted = false;
    }
}
