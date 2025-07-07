package qbckrt.qayaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionOutputDTO {

    // FIELDS
    private String id;
    private String title;
    private String description;
    private String type;
    private CategoryOutputDTO category;
    private String userId;
    private String amount;
    private String date;
    private AccountOutputDTO account;
    private CurrencyOutputDTO currency;
    private String createdAt;

    // CONSTRUCTORS
    public TransactionOutputDTO(
            String id,
            String title,
            String description,
            String type,
            CategoryOutputDTO category,
            String userId,
            String amount,
            String date,
            AccountOutputDTO account,
            CurrencyOutputDTO currency,
            String createdAt
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.category = category;
        this.userId = userId;
        this.amount = amount;
        this.date = date;
        this.account = account;
        this.currency = currency;
        this.createdAt = createdAt;
    }
}
