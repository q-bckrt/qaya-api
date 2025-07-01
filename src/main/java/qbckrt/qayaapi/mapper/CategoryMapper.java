package qbckrt.qayaapi.mapper;

import org.springframework.stereotype.Component;
import qbckrt.qayaapi.dto.CategoryInputDTO;
import qbckrt.qayaapi.dto.CategoryOutputDTO;
import qbckrt.qayaapi.entity.Category;
import qbckrt.qayaapi.enums.TransactionType;
import qbckrt.qayaapi.repository.UserRepository;

import java.util.UUID;

@Component
public class CategoryMapper {

    // FIELDS
    private final UserRepository userRepository;

    // CONSTRUCTOR
    public CategoryMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // METHODS
    public Category toEntity(CategoryInputDTO categoryInputDTO) {
        UUID userIdAsUUID = UUID.fromString(categoryInputDTO.getUserId());

        return new Category(
                categoryInputDTO.getLabel(),
                categoryInputDTO.getDescription(),
                TransactionType.valueOf(categoryInputDTO.getType()),
                categoryInputDTO.getIconKey(),
                userRepository.findById(userIdAsUUID)
                        .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + categoryInputDTO.getUserId()))
        );
    }

    public CategoryOutputDTO toDTO(Category category) {
        return new CategoryOutputDTO(
                category.getId().toString(),
                category.getLabel(),
                category.getDescription(),
                category.getType().name(),
                category.getIconKey(),
                category.getUserId().getId().toString(),
                category.getCreatedAt().toString()
        );
    }
}
