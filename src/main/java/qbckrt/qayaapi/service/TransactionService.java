package qbckrt.qayaapi.service;

import org.springframework.stereotype.Service;
import qbckrt.qayaapi.dto.TransactionInputDTO;
import qbckrt.qayaapi.dto.TransactionOutputDTO;
import qbckrt.qayaapi.entity.Transaction;
import qbckrt.qayaapi.mapper.TransactionMapper;
import qbckrt.qayaapi.repository.TransactionRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    // FIELDS
    TransactionRepository transactionRepository;
    TransactionMapper transactionMapper;

    // CONSTRUCTOR
    public TransactionService(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    // METHODS
    public TransactionOutputDTO getTransactionById(String transactionId) {
        UUID transactionIdAsUUID = UUID.fromString(transactionId);

        return transactionRepository.findById(transactionIdAsUUID)
                .map(transactionMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + transactionId));

    }

    public List<TransactionOutputDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(transactionMapper::toDTO)
                .toList();
    }

    public TransactionOutputDTO createTransaction(TransactionInputDTO transactionInputDTO) {
        Transaction transactionEntity = transactionMapper.toEntity(transactionInputDTO);
        Transaction savedTransaction = transactionRepository.save(transactionEntity);

        return transactionMapper.toDTO(savedTransaction);
    }
}
