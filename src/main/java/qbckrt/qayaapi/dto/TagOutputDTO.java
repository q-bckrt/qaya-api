package qbckrt.qayaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagOutputDTO {

    // FIELDS
    private String id;
    private String label;
    private String userId;
    private String createdAt;

    // CONSTRUCTORS
    public TagOutputDTO(String id, String label, String userId, String createdAt) {
        this.id = id;
        this.label = label;
        this.userId = userId;
        this.createdAt = createdAt;
    }

}
