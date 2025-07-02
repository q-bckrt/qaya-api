package qbckrt.qayaapi.service;

import org.springframework.stereotype.Service;
import qbckrt.qayaapi.dto.TagInputDTO;
import qbckrt.qayaapi.dto.TagOutputDTO;
import qbckrt.qayaapi.entity.Tag;
import qbckrt.qayaapi.mapper.TagMapper;
import qbckrt.qayaapi.repository.TagRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TagService {

    // FIELDS
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

        return tagRepository.findById(tagIdAsUUID)
                .map(tagMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Tag not found with id: " + tagId));
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
