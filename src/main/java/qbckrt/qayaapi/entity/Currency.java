package qbckrt.qayaapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "currencies")
public class Currency {

    // FIELDS
    @Id
    private String code;
    @Column(name = "symbol", nullable = false, unique = true)
    private String symbol;
    @Column(name = "currency_name", nullable = false, unique = true)
    private String name;
    @Column(name = "precision", nullable = false)
    private Integer precision;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    // CONSTRUCTORS
    public Currency() {
        // Default constructor for JPA
    }
}