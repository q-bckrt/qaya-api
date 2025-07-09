package qbckrt.qayaapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import qbckrt.qayaapi.dto.TransactionInputDTO;
import qbckrt.qayaapi.dto.TransactionOutputDTO;
import qbckrt.qayaapi.service.TransactionService;


@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransactionController {

    // FIELDS
    private final TransactionService transactionService;

    // CONSTRUCTOR
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // METHODS
    @GetMapping(path = "/{id}" ,produces = "application/json")
    public TransactionOutputDTO getTransactionById(@PathVariable("id") String transactionId) {
        return transactionService.getTransactionById(transactionId);
    }

    @GetMapping(produces = "application/json")
    public List<TransactionOutputDTO> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public TransactionOutputDTO createTransaction(@RequestBody TransactionInputDTO transactionInputDTO) {
        return transactionService.createTransaction(transactionInputDTO);
    }
}