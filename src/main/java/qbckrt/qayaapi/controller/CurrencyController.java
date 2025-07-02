package qbckrt.qayaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import qbckrt.qayaapi.dto.CurrencyOutputDTO;
import qbckrt.qayaapi.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    // FIELDS
    private final CurrencyService currencyService;

    // CONSTRUCTOR
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    // METHODS
    @GetMapping(path = "/{code}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CurrencyOutputDTO getCurrencyByCode(@PathVariable("code") String code) {
        return currencyService.getCurrencyByCode(code);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CurrencyOutputDTO> getCurrencies() {
        return currencyService.getCurrencies();
    }
}
