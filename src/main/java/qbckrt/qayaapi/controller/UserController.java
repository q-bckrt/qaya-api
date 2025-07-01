package qbckrt.qayaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import qbckrt.qayaapi.dto.UserInputDTO;
import qbckrt.qayaapi.dto.UserOutputDTO;
import qbckrt.qayaapi.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    // FIELDS
    private final UserService userService;

    // CONSTRUCTOR
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // METHODS
    @GetMapping(path = "/{id}" ,produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserOutputDTO getUserById(@PathVariable("id") String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<UserOutputDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserOutputDTO createUser(@RequestBody UserInputDTO userInputDTO) {
        return userService.createUser(userInputDTO);
    }
}
