package qbckrt.qayaapi.service;

import org.springframework.stereotype.Service;
import qbckrt.qayaapi.dto.CurrencyOutputDTO;
import qbckrt.qayaapi.mapper.CurrencyMapper;
import qbckrt.qayaapi.repository.CurrencyRepository;

import java.util.List;

@Service
public class CurrencyService {

    // FIELDS
    private final CurrencyMapper currencyMapper;
    private final CurrencyRepository currencyRepository;

    // CONSTRUCTOR
    public CurrencyService(CurrencyMapper currencyMapper, CurrencyRepository currencyRepository) {
        this.currencyMapper = currencyMapper;
        this.currencyRepository = currencyRepository;
    }

    // METHODS
    public CurrencyOutputDTO getCurrencyByCode(String code) {
        return currencyRepository.findByCode(code)
                .map(currencyMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Currency not found with code: " + code));
    }

    public List<CurrencyOutputDTO> getCurrencies() {
        return currencyRepository.findAll().stream()
                .map(currencyMapper::toDTO)
                .toList();
    }
}
