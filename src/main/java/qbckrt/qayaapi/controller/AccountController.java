package qbckrt.qayaapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import qbckrt.qayaapi.dto.AccountInputDTO;
import qbckrt.qayaapi.dto.AccountOutputDTO;
import qbckrt.qayaapi.service.AccountService;


@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {

    // DEPENDENCIES
    private final AccountService accountService;

    // CONSTRUCTOR
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // METHODS
    @GetMapping(path = "/{id}", produces = "application/json")
    public AccountOutputDTO getAccountById(@PathVariable("id") String accountId) {
        return accountService.getAccountById(accountId);
    }

    @GetMapping(produces = "application/json")
    public List<AccountOutputDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public AccountOutputDTO createAccount(@RequestBody AccountInputDTO accountInputDTO) {
        return accountService.createAccount(accountInputDTO);
    }
}