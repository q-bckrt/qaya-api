package qbckrt.qayaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import qbckrt.qayaapi.dto.TagInputDTO;
import qbckrt.qayaapi.dto.TagOutputDTO;
import qbckrt.qayaapi.service.TagService;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    // FIELDS
    private TagService tagService;

    // CONSTRUCTOR
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    // METHODS
    @GetMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public TagOutputDTO getTagById(@PathVariable("Id") String Id) {
        return tagService.getTagById(Id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TagOutputDTO> getAllTags() {
        return tagService.getAllTags();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TagOutputDTO createTag(@RequestBody TagInputDTO tagInputDTO) {
        return tagService.createTag(tagInputDTO);
    }
}
