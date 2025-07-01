package qbckrt.qayaapi.entity;

import jakarta.persistence.Convert;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import qbckrt.qayaapi.converter.LocaleAttributeConverter;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;
import java.time.ZoneId;

@Getter
@Setter
public class User {

    // FIELDS
    private UUID id;
    private String displayName;
    private String email;
    @Convert(converter = LocaleAttributeConverter.class)
    private Locale locale;
    @Convert(converter = Jsr310JpaConverters.ZoneIdConverter.class)
    private ZoneId timeZone;
    private String countryCode;
    private String currencyCode;
    private String profilePictureUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isDeleted;

    // CONSTRUCTORS
    public User() {}
    public User(String displayName, String email, Locale locale, ZoneId timeZone, String countryCode,
                String currencyCode, String profilePictureUrl, LocalDateTime createdAt, LocalDateTime updatedAt,
                boolean isDeleted) {
        this.id = UUID.randomUUID();
        this.displayName = displayName;
        this.email = email;
        this.locale = locale;
        this.timeZone = timeZone;
        this.countryCode = countryCode;
        this.currencyCode = currencyCode;
        this.profilePictureUrl = profilePictureUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
    }
}
