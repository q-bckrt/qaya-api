package qbckrt.qayaapi.dto;


public class CategoryInputDTO {

    // FIELDS
    private String label;
    private String description;
    private String type;
    private String iconKey;
    private String userId;

    // CONSTRUCTORS
    public CategoryInputDTO(
            String label,
            String description,
            String type,
            String iconKey,
            String userId
    ) {
        this.label = label;
        this.description = description;
        this.type = type;
        this.iconKey = iconKey;
        this.userId = userId;
    }
}
