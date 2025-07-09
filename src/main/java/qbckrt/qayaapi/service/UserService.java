package qbckrt.qayaapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import qbckrt.qayaapi.dto.UserInputDTO;
import qbckrt.qayaapi.dto.UserOutputDTO;
import qbckrt.qayaapi.entity.User;
import qbckrt.qayaapi.mapper.UserMapper;
import qbckrt.qayaapi.repository.UserRepository;


@Service
public class UserService {

    // DEPENDENCIES
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // CONSTRUCTOR
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // METHODS
    public UserOutputDTO getUserById(String userId) {
        UUID userIdAsUUID = UUID.fromString(userId);

        User user = userRepository.findById(userIdAsUUID)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        return userMapper.toDTO(user);
    }

    public List<UserOutputDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .toList();
    }

    public UserOutputDTO createUser(UserInputDTO userInputDTO) {
        User userEntity = userMapper.toEntity(userInputDTO);
        User savedUser = userRepository.save(userEntity);

        return userMapper.toDTO(savedUser);
    }
}
