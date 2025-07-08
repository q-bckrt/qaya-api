package qbckrt.qayaapi.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import java.time.ZoneId;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import qbckrt.qayaapi.converter.LocaleAttributeConverter;


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
    @Column(name = "profile_picture")
    private String profilePictureUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency", nullable = false)
    private Currency currency;
    @ManyToMany
    @JoinTable(
            name = "accounts_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private List<Account> accounts = new ArrayList<>();

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    // CONSTRUCTORS
    public User() {
        // Default constructor for JPA
    }

    public User(
            String displayName,
            String email,
            Locale locale,
            ZoneId timeZone,
            String countryCode,
            Currency currency,
            String profilePictureUrl,
            boolean isDeleted
    ) {
        this.id = UUID.randomUUID();

        this.displayName       = displayName;
        this.email             = email;
        this.locale            = locale;
        this.timeZone          = timeZone;
        this.countryCode       = countryCode;
        this.currency          = currency;
        this.profilePictureUrl = profilePictureUrl;

        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.isDeleted = isDeleted;
    }

    // METHODS
    public void addAccount(Account account) {
        if (account != null && !this.accounts.contains(account)) {
            this.accounts.add(account);
            account.getUsers().add(this);
        }
    }
}