package qbckrt.qayaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import qbckrt.qayaapi.dto.CategoryInputDTO;
import qbckrt.qayaapi.dto.CategoryOutputDTO;
import qbckrt.qayaapi.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

    // FIELDS
    private final CategoryService categoryService;

    // CONSTRUCTOR
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // METHODS
    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CategoryOutputDTO getCategoryById(@PathVariable("id") String id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryOutputDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryOutputDTO createCategory(@RequestBody CategoryInputDTO categoryInputDTO) {
        return categoryService.createCategory(categoryInputDTO);
    }
}
