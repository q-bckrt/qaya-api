package qbckrt.qayaapi.service;

import org.springframework.stereotype.Service;
import qbckrt.qayaapi.dto.CategoryInputDTO;
import qbckrt.qayaapi.dto.CategoryOutputDTO;
import qbckrt.qayaapi.entity.Category;
import qbckrt.qayaapi.mapper.CategoryMapper;
import qbckrt.qayaapi.repository.CategoryRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    // FIELDS
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    // CONSTRUCTOR
    public CategoryService(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    // METHODS
    public CategoryOutputDTO getCategoryById(String id) {
        UUID idAsUUID = UUID.fromString(id);

        return categoryRepository.findById(idAsUUID)
                .map(categoryMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    public List<CategoryOutputDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDTO)
                .toList();
    }

    public CategoryOutputDTO createCategory(CategoryInputDTO categoryInputDTO) {
        Category categoryEntity = categoryMapper.toEntity(categoryInputDTO);
        Category savedCategory = categoryRepository.save(categoryEntity);
        return categoryMapper.toDTO(savedCategory);
    }
}
