package qbckrt.qayaapi.mapper;

import org.springframework.stereotype.Component;
import qbckrt.qayaapi.dto.TagInputDTO;
import qbckrt.qayaapi.dto.TagOutputDTO;
import qbckrt.qayaapi.entity.Tag;
import qbckrt.qayaapi.entity.User;
import qbckrt.qayaapi.repository.UserRepository;

import java.util.UUID;

@Component
public class TagMapper {

    private final UserRepository userRepository;

    // CONSTRUCTOR
    public TagMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // METHODS
    public Tag toEntity (TagInputDTO tagInputDTO) {
        UUID UserIdAsUUID = UUID.fromString(tagInputDTO.getUserId());
        User user = userRepository.findById(UserIdAsUUID)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + tagInputDTO.getUserId()));
        return new Tag(
                tagInputDTO.getLabel(),
                user
        );
    }

    public TagOutputDTO toDTO(Tag tag) {
        return new TagOutputDTO(
                tag.getId().toString(),
                tag.getLabel(),
                tag.getUser().getId().toString(),
                tag.getCreatedAt().toString()
        );
    }
}