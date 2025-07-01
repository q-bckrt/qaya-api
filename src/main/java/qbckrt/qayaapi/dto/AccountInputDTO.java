package qbckrt.qayaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountInputDTO {

    // FIELDS
    private String title;
    private String description;
    private String currency;
    private boolean allowOverdraft;
    private String iconKey;
    private String userId;

    // CONSTRUCTOR
    public AccountInputDTO(String title, String description, String currency, boolean allowOverdraft, String iconKey, String userId) {
        this.title = title;
        this.description = description;
        this.currency = currency;
        this.allowOverdraft = allowOverdraft;
        this.iconKey = iconKey;
        this.userId = userId;
    }
}
