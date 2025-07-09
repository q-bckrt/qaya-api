package qbckrt.qayaapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import qbckrt.qayaapi.dto.CurrencyOutputDTO;
import qbckrt.qayaapi.service.CurrencyService;


@RestController
@RequestMapping("/currencies")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CurrencyController {

    // DEPENDENCIES
    private final CurrencyService currencyService;

    // CONSTRUCTOR
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    // METHODS
    @GetMapping(path = "/{code}", produces = "application/json")
    public CurrencyOutputDTO getCurrencyByCode(@PathVariable("code") String code) {
        return currencyService.getCurrencyByCode(code);
    }

    @GetMapping
    public List<CurrencyOutputDTO> getCurrencies() {
        return currencyService.getCurrencies();
    }
}
