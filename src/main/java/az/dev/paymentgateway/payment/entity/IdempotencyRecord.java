package az.dev.paymentgateway.payment.entity;

import az.dev.paymentgateway.payment.enums.IdempotencyStatus;
import az.dev.paymentgateway.payment.enums.OperationType;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.Instant;

@Entity
@Table(name = "idempotency_record")
public class IdempotencyRecord {

    protected IdempotencyRecord() {}

    public IdempotencyRecord(String idempotencyKey, OperationType operationType, String requestHash) {
        this.idempotencyKey = idempotencyKey;
        this.operationType = operationType;
        this.requestHash = requestHash;
        this.status = IdempotencyStatus.PROCESSING;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false, unique = true)
    @Getter
    private String idempotencyKey;

    @Column(nullable = false)
    @Getter
    private String requestHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Getter
    private IdempotencyStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Getter
    private OperationType operationType;

    @Column(columnDefinition = "TEXT")
    @Getter
    private String response;

    @Column(nullable = false)
    @Getter
    private Instant createdAt;


    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
    }
}
