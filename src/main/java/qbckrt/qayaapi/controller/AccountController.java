package qbckrt.qayaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import qbckrt.qayaapi.dto.AccountInputDTO;
import qbckrt.qayaapi.dto.AccountOutputDTO;
import qbckrt.qayaapi.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    // FIELDS
    private final AccountService accountService;

    // CONSTRUCTOR
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // METHODS
    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public AccountOutputDTO getAccountById(@PathVariable("id") String accountId) {
        return accountService.getAccountById(accountId);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountOutputDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountOutputDTO createAccount(@RequestBody AccountInputDTO accountInputDTO) {
        return accountService.createAccount(accountInputDTO);
    }
}
