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
    private CurrencyOutputDTO currency;
    private boolean allowOverdraft;
    private String iconKey;
    private String createdAt;

    // CONSTRUCTOR
    public AccountOutputDTO(String id, String title, String description, CurrencyOutputDTO currency, boolean allowOverdraft, String iconKey, String createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.currency = currency;
        this.allowOverdraft = allowOverdraft;
        this.iconKey = iconKey;
        this.createdAt = createdAt;
    }
}
