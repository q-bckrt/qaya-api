package qbckrt.qayaapi.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import qbckrt.qayaapi.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "transactions")
public class Transaction {

    // FIELDS
    @Id
    private UUID id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TransactionType type; // Enum for transaction type (e.g., INCOME, EXPENSE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "savings_goal_id")
    private SavingGoal savingsGoal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    // CONSTRUCTORS
    public Transaction(){}
    public Transaction(String title, String description, BigDecimal amount, LocalDate date, TransactionType type) {
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.isDeleted = false;

        this.title = title;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.account = null; // Will be set later
        this.category = null; // Will be set later
        this.savingsGoal = null; // Will be set later
    }
}
