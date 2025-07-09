package qbckrt.qayaapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import qbckrt.qayaapi.dto.TagInputDTO;
import qbckrt.qayaapi.dto.TagOutputDTO;
import qbckrt.qayaapi.entity.Tag;
import qbckrt.qayaapi.mapper.TagMapper;
import qbckrt.qayaapi.repository.TagRepository;


@Service
public class TagService {

    // DEPENDENCIES
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    // CONSTRUCTOR
    public TagService(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    // METHODS
    public TagOutputDTO getTagById(String tagId) {
        UUID tagIdAsUUID = UUID.fromString(tagId);

        Tag tag = tagRepository.findById(tagIdAsUUID)
                .orElseThrow(() -> new RuntimeException("Tag not found with id: " + tagId));

        return tagMapper.toDTO(tag);
    }

    public List<TagOutputDTO> getAllTags() {
        return tagRepository.findAll().stream()
                .map(tagMapper::toDTO)
                .toList();
    }

    public TagOutputDTO createTag(TagInputDTO tagInputDTO) {
        Tag tagEntity = tagMapper.toEntity(tagInputDTO);
        Tag savedTag = tagRepository.save(tagEntity);

        return tagMapper.toDTO(savedTag);
    }
}
