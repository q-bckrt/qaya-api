package qbckrt.qayaapi.service;

import org.springframework.stereotype.Service;
import qbckrt.qayaapi.dto.AccountInputDTO;
import qbckrt.qayaapi.dto.AccountOutputDTO;
import qbckrt.qayaapi.entity.Account;
import qbckrt.qayaapi.entity.User;
import qbckrt.qayaapi.mapper.AccountMapper;
import qbckrt.qayaapi.repository.AccountRepository;
import qbckrt.qayaapi.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    // FIELDS
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final UserRepository userRepository;

    // CONSTRUCTOR
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.userRepository = userRepository;
    }

    // METHODS
    public AccountOutputDTO getAccountById(String accountId) {
        UUID accountIdAsUUID = UUID.fromString(accountId);

        return accountRepository.findById(accountIdAsUUID)
                .map(accountMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + accountId));
    }

    public List<AccountOutputDTO> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(accountMapper::toDTO)
                .toList();
    }

    public AccountOutputDTO createAccount(AccountInputDTO accountInputDTO) {
        Account accountEntity = accountMapper.toEntity(accountInputDTO);
        Account savedAccount = accountRepository.save(accountEntity);

        UUID userId = UUID.fromString(accountInputDTO.getUserId());
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + accountInputDTO.getUserId()));
        user.addAccount(accountEntity);
        userRepository.save(user);

        return accountMapper.toDTO(savedAccount);
    }
}
