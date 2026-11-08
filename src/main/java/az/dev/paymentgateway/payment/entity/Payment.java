package az.dev.paymentgateway.payment.entity;

import az.dev.paymentgateway.payment.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "payments")
public class Payment {

    protected Payment() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String customerId;

    @Column(nullable = false)
    @Getter
    @Setter
    private String orderId;

    @Column(nullable = false)
    @Getter
    @Setter
    private Long amount;

    @Column(nullable = false)
    @Getter
    @Setter
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Getter
    private PaymentStatus paymentStatus;

    @Column
    @Getter
    @Setter
    private String authorizationId;

    @Column
    @Getter
    @Setter
    private String captureId;

    @Column(nullable = false, updatable = false)
    @Getter
    private Instant createdAt;

    @Column(nullable = false)
    @Getter
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }



}
