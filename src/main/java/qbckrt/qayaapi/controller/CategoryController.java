package qbckrt.qayaapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import qbckrt.qayaapi.dto.CategoryInputDTO;
import qbckrt.qayaapi.dto.CategoryOutputDTO;
import qbckrt.qayaapi.service.CategoryService;


@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

    // DEPENDENCIES
    private final CategoryService categoryService;

    // CONSTRUCTOR
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // METHODS
    @GetMapping(path = "/{id}", produces = "application/json")
    public CategoryOutputDTO getCategoryById(@PathVariable("id") String id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping(produces = "application/json")
    public List<CategoryOutputDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public CategoryOutputDTO createCategory(@RequestBody CategoryInputDTO categoryInputDTO) {
        return categoryService.createCategory(categoryInputDTO);
    }
}