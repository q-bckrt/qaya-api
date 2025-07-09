package qbckrt.qayaapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import qbckrt.qayaapi.dto.CategoryInputDTO;
import qbckrt.qayaapi.dto.CategoryOutputDTO;
import qbckrt.qayaapi.entity.Category;
import qbckrt.qayaapi.mapper.CategoryMapper;
import qbckrt.qayaapi.repository.CategoryRepository;


@Service
public class CategoryService {

    // DEPENDENCIES
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

        Category category = categoryRepository.findById(idAsUUID)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        return categoryMapper.toDTO(category);
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
