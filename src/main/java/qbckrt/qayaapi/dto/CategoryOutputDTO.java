package qbckrt.qayaapi.dto;

public class CategoryOutputDTO {

    // FIELDS
    private String id;
    private String label;
    private String description;
    private String type;
    private String iconKey;
    private String userId;
    private String createdAt;

    // CONSTRUCTORS
    public CategoryOutputDTO(
            String id,
            String label,
            String description,
            String type,
            String iconKey,
            String userId,
            String createdAt
    ) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.type = type;
        this.iconKey = iconKey;
        this.userId = userId;
        this.createdAt = createdAt;
    }
}
