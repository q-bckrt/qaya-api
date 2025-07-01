package qbckrt.qayaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOutputDTO {

    // FIELDS
    private String id;
    private String displayName;
    private String email;
    private String locale;
    private String timeZone;
    private String countryCode;
    private String currency;
    private String profilePictureUrl;
    private String createdAt;

    // CONSTRUCTOR
    public UserOutputDTO(String id, String displayName, String email, String locale, String timeZone, String countryCode, String currency, String profilePictureUrl, String createdAt) {
        this.id = id;
        this.displayName = displayName;
        this.email = email;
        this.locale = locale;
        this.timeZone = timeZone;
        this.countryCode = countryCode;
        this.currency = currency;
        this.profilePictureUrl = profilePictureUrl;
        this.createdAt = createdAt;
    }
}
