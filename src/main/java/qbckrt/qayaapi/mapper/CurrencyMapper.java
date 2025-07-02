package qbckrt.qayaapi.mapper;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;
import qbckrt.qayaapi.dto.CurrencyOutputDTO;
import qbckrt.qayaapi.entity.Currency;

@Component
public class CurrencyMapper {

    // METHODS
    public CurrencyOutputDTO toDTO(Currency currency) {
        return new CurrencyOutputDTO(
                currency.getCode(),
                currency.getSymbol(),
                currency.getName(),
                currency.getPrecision()
        );
    }
}
