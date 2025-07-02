package qbckrt.qayaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import qbckrt.qayaapi.dto.TransactionInputDTO;
import qbckrt.qayaapi.dto.TransactionOutputDTO;
import qbckrt.qayaapi.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    // FIELDS
    private final TransactionService transactionService;

    // CONSTRUCTOR
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // METHODS
    @GetMapping(path = "/{id}" ,produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionOutputDTO getTransactionById(@PathVariable("id") String transactionId) {
        return transactionService.getTransactionById(transactionId);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionOutputDTO> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionOutputDTO createTransaction(@RequestBody TransactionInputDTO transactionInputDTO) {
        return transactionService.createTransaction(transactionInputDTO);
    }
}
