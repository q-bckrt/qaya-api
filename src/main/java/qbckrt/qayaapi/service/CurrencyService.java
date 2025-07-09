package qbckrt.qayaapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import qbckrt.qayaapi.dto.CurrencyOutputDTO;
import qbckrt.qayaapi.entity.Currency;
import qbckrt.qayaapi.mapper.CurrencyMapper;
import qbckrt.qayaapi.repository.CurrencyRepository;


@Service
public class CurrencyService {

    // DEPENDENCIES
    private final CurrencyMapper currencyMapper;
    private final CurrencyRepository currencyRepository;

    // CONSTRUCTOR
    public CurrencyService(CurrencyMapper currencyMapper, CurrencyRepository currencyRepository) {
        this.currencyMapper = currencyMapper;
        this.currencyRepository = currencyRepository;
    }

    // METHODS
    public CurrencyOutputDTO getCurrencyByCode(String code) {
        Currency currency = currencyRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Currency not found with code: " + code));

        return currencyMapper.toDTO(currency);
    }

    public List<CurrencyOutputDTO> getCurrencies() {
        return currencyRepository.findAll().stream()
                .map(currencyMapper::toDTO)
                .toList();
    }
}