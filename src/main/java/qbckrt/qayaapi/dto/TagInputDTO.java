package qbckrt.qayaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagInputDTO {

    // FIELDS
    private String label;
    private String userId;

    // CONSTRUCTORS
    public TagInputDTO(String label, String userId) {
        this.label = label;
        this.userId = userId;
    }
}
