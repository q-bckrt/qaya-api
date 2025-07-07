package qbckrt.qayaapi.mapper;

import org.springframework.stereotype.Component;
import qbckrt.qayaapi.dto.TransactionInputDTO;
import qbckrt.qayaapi.dto.TransactionOutputDTO;
import qbckrt.qayaapi.entity.Account;
import qbckrt.qayaapi.entity.Category;
import qbckrt.qayaapi.entity.Transaction;
import qbckrt.qayaapi.entity.User;
import qbckrt.qayaapi.enums.TransactionType;
import qbckrt.qayaapi.repository.AccountRepository;
import qbckrt.qayaapi.repository.CategoryRepository;
import qbckrt.qayaapi.repository.CurrencyRepository;
import qbckrt.qayaapi.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class TransactionMapper {

    // FIELDS
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final AccountRepository accountRepository;
    private final CurrencyMapper currencyMapper;
    private final AccountMapper accountMapper;
    private final CategoryMapper categoryMapper;

    // CONSTRUCTOR
    public TransactionMapper(
            UserRepository userRepository,
            CategoryRepository categoryRepository,
            AccountRepository accountRepository,
            CurrencyMapper currencyMapper,
            AccountMapper accountMapper,
            CategoryMapper categoryMapper
    ) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.accountRepository = accountRepository;
        this.currencyMapper = currencyMapper;
        this.accountMapper = accountMapper;
        this.categoryMapper = categoryMapper;
    }

    // METHODS
    public Transaction toEntity(TransactionInputDTO transactionInputDTO) {
        UUID userIdAsUUID = UUID.fromString(transactionInputDTO.getUserId());
        UUID categoryIdAsUUID = UUID.fromString(transactionInputDTO.getCategoryId());
        UUID accountIdAsUUID = UUID.fromString(transactionInputDTO.getAccountId());

        User user = userRepository.findById(userIdAsUUID)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + transactionInputDTO.getUserId()));
        Category category = categoryRepository.findById(categoryIdAsUUID)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + transactionInputDTO.getCategoryId()));
        Account account = accountRepository.findById(accountIdAsUUID)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with id: " + transactionInputDTO.getAccountId()));

        BigDecimal amount = transactionInputDTO.getAmount() != null
                ? new BigDecimal(transactionInputDTO.getAmount())
                : BigDecimal.ZERO;

        LocalDate date = transactionInputDTO.getDate() != null
                ? LocalDate.parse(transactionInputDTO.getDate())
                : LocalDate.now();

        return new Transaction(
                transactionInputDTO.getTitle(),
                transactionInputDTO.getDescription(),
                amount,
                date,
                TransactionType.valueOf(transactionInputDTO.getType()),
                account,
                category,
                user
        );
    }

    public TransactionOutputDTO toDTO(Transaction transaction) {
        return new TransactionOutputDTO(
                transaction.getId().toString(),
                transaction.getTitle(),
                transaction.getDescription(),
                transaction.getType().name(),
                categoryMapper.toDTO(transaction.getCategory()),
                transaction.getUser().getId().toString(),
                transaction.getAmount().toString(),
                transaction.getDate().toString(),
                accountMapper.toDTO(transaction.getAccount()),
                currencyMapper.toDTO(transaction.getAccount().getCurrency()),
                transaction.getCreatedAt().toString()
        );
    }
}
