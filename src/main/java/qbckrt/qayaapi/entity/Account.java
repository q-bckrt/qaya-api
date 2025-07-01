package qbckrt.qayaapi.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "accounts")
public class Account {

    // FIELDS
    @Id
    private UUID id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency", nullable = false)
    private Currency currency;
    @Column(name = "allow_overdraft", nullable = false)
    private boolean allowOverdraft;
    @Column(name = "icon_key", nullable = false)
    private String iconKey;
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @ManyToMany(
            mappedBy = "accounts",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private List<User> users = new ArrayList<>();

    // CONSTRUCTORS
    public Account() {}
    public Account(String title, String description, Currency currency, boolean allowOverdraft, String iconKey) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.currency = currency;
        this.allowOverdraft = allowOverdraft;
        this.iconKey = iconKey;
    }

}
