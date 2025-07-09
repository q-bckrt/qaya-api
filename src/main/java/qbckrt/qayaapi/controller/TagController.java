package qbckrt.qayaapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import qbckrt.qayaapi.dto.TagInputDTO;
import qbckrt.qayaapi.dto.TagOutputDTO;
import qbckrt.qayaapi.service.TagService;


@RestController
@RequestMapping("/tags")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TagController {

    // DEPENDENCIES
    private final TagService tagService;

    // CONSTRUCTOR
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    // METHODS
    @GetMapping("/{Id}")
    public TagOutputDTO getTagById(@PathVariable("Id") String Id) {
        return tagService.getTagById(Id);
    }

    @GetMapping
    public List<TagOutputDTO> getAllTags() {
        return tagService.getAllTags();
    }

    @PostMapping
    public TagOutputDTO createTag(@RequestBody TagInputDTO tagInputDTO) {
        return tagService.createTag(tagInputDTO);
    }
}
