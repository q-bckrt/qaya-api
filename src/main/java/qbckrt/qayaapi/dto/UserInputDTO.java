package qbckrt.qayaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInputDTO {

    // FIELDS
    private String displayName;
    private String email;
    private String locale;
    private String timezone;
    private String countryCode;
    private String currency;
    private String profilePictureUrl;

    // CONSTRUCTOR
    public UserInputDTO(String displayName, String email, String locale, String timezone, String countryCode, String currency, String profilePictureUrl) {
        this.displayName = displayName;
        this.email = email;
        this.locale = locale;
        this.timezone = timezone;
        this.countryCode = countryCode;
        this.currency = currency;
        this.profilePictureUrl = profilePictureUrl;
    }
}
