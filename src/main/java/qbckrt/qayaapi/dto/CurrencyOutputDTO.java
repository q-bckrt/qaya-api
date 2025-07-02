package qbckrt.qayaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyOutputDTO {

    // FIELDS
    private String code; // ISO 4217 currency code, e.g., "USD", "EUR"
    private String symbol; // Currency symbol, e.g., "$", "€"
    private String name; // Full name of the currency, e.g., "United States Dollar", "Euro"
    private Integer precision; // Number of decimal places for the currency

    // CONSTRUCTOR
    public CurrencyOutputDTO(String code, String symbol, String name, Integer precision) {
        this.code = code;
        this.symbol = symbol;
        this.name = name;
        this.precision = precision;
    }

}
