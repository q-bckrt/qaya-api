package qbckrt.qayaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountInputDTO {

    // FIELDS
    private String title;
    private String description;
    private String currencyCode;
    private boolean allowOverdraft;
    private String iconKey;

    // CONSTRUCTOR
    public AccountInputDTO(String title, String description, String currencyCode, boolean allowOverdraft, String iconKey) {
        this.title = title;
        this.description = description;
        this.currencyCode = currencyCode;
        this.allowOverdraft = allowOverdraft;
        this.iconKey = iconKey;
    }
}
