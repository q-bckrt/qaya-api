package qbckrt.qayaapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "currencies")
public class Currency {

    // FIELDS
    @Id
    @Column(name = "code", nullable = false, unique = true)
    private String code; // ISO 4217 currency code, e.g., "USD", "EUR"
    @Column(name = "symbol", nullable = false, unique = true)
    private String symbol; // Currency symbol, e.g., "$", "€"
    @Column(name = "currency_name", nullable = false, unique = true)
    private String name; // Full name of the currency, e.g., "United States Dollar", "Euro"
    @Column(name = "precision", nullable = false)
    private Integer precision; // Number of decimal places for the currency
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    // CONSTRUCTOR
    public Currency() {
        // Default constructor for JPA
    }

    public Currency(String code, String symbol, String name, Integer precision, boolean isDeleted) {
        this.code = code;
        this.symbol = symbol;
        this.name = name;
        this.precision = precision;
        this.isDeleted = isDeleted;
    }
}
