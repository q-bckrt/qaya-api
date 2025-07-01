package qbckrt.qayaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountOutputDTO {

    // FIELDS
    private String id;
    private String title;
    private String description;
    private String currencyCode;
    private boolean allowOverdraft;
    private String iconKey;

    // CONSTRUCTOR
    public AccountOutputDTO(String id, String title, String description, String currencyCode, boolean allowOverdraft, String iconKey) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.currencyCode = currencyCode;
        this.allowOverdraft = allowOverdraft;
        this.iconKey = iconKey;
    }
}
