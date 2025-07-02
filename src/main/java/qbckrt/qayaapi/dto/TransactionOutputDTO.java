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
    private String categoryId;
    private String userId;
    private String amount;
    private String date;
    private String accountId;
    private String createdAt;

    // CONSTRUCTORS
    public TransactionOutputDTO(
            String id,
            String title,
            String description,
            String type,
            String categoryId,
            String userId,
            String amount,
            String date,
            String accountId,
            String createdAt
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.categoryId = categoryId;
        this.userId = userId;
        this.amount = amount;
        this.date = date;
        this.accountId = accountId;
        this.createdAt = createdAt;
    }
}
