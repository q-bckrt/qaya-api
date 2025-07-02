package qbckrt.qayaapi.mapper;

import org.springframework.stereotype.Component;
import qbckrt.qayaapi.dto.AccountInputDTO;
import qbckrt.qayaapi.dto.AccountOutputDTO;
import qbckrt.qayaapi.entity.Account;
import qbckrt.qayaapi.entity.Currency;
import qbckrt.qayaapi.entity.User;
import qbckrt.qayaapi.repository.CurrencyRepository;
import qbckrt.qayaapi.repository.UserRepository;

import java.util.UUID;

@Component
public class AccountMapper {

    private final UserRepository userRepository;
    // FIELDS
    CurrencyRepository currencyRepository;

    // CONSTRUCTOR
    public AccountMapper(CurrencyRepository currencyRepository, UserRepository userRepository) {
        this.currencyRepository = currencyRepository;
        this.userRepository = userRepository;
    }

    // METHODS
    public Account toEntity (AccountInputDTO accountInputDTO) {
        Currency currency = currencyRepository.findById(accountInputDTO.getCurrency())
                .orElseThrow(); // ???

        return new Account(
                accountInputDTO.getTitle(),
                accountInputDTO.getDescription(),
                currency,
                accountInputDTO.isAllowOverdraft(),
                accountInputDTO.getIconKey()
        );
    }

    public AccountOutputDTO toDTO(Account account) {
        return new AccountOutputDTO(
                account.getId().toString(),
                account.getTitle(),
                account.getDescription(),
                account.getCurrency().getCode(),
                account.isAllowOverdraft(),
                account.getIconKey(),
                account.getCreatedAt().toString()
        );
    }
}
