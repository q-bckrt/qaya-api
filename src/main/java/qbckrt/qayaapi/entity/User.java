package qbckrt.qayaapi.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import qbckrt.qayaapi.converter.LocaleAttributeConverter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import java.time.ZoneId;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {

    // FIELDS
    @Id
    private UUID id;
    @Column(name = "display_name", nullable = false)
    private String displayName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "locale", nullable = false)
    @Convert(converter = LocaleAttributeConverter.class)
    private Locale locale;
    @Column(name = "timezone", nullable = false)
    @Convert(converter = Jsr310JpaConverters.ZoneIdConverter.class)
    private ZoneId timeZone;
    @Column(name = "country_code")
    private String countryCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency", nullable = false)
    private Currency currency;
    @Column(name = "profile_picture")
    private String profilePictureUrl;
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @ManyToMany
    @JoinTable(
            name = "accounts_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private List<Account> accounts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "saving_goals_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "saving_goal_id")
    )
    private List<SavingGoal> savingGoals = new ArrayList<>();

    // CONSTRUCTORS
    public User() {}
    public User(String displayName, String email, Locale locale, ZoneId timeZone, String countryCode,
                Currency currency, String profilePictureUrl, boolean isDeleted) {
        this.id = UUID.randomUUID();
        this.displayName = displayName;
        this.email = email;
        this.locale = locale;
        this.timeZone = timeZone;
        this.countryCode = countryCode;
        this.currency = currency;
        this.profilePictureUrl = profilePictureUrl;
        this.isDeleted = isDeleted;
    }
}
