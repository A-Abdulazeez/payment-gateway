package az.dev.paymentgateway.payment.entity;

import az.dev.paymentgateway.payment.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.Instant;

@Entity
@Table(name = "payment_history")
public class PaymentHistory {

    protected PaymentHistory() {}

    public PaymentHistory(Payment payment, PaymentStatus previousStatus, PaymentStatus newStatus) {
        this.payment = payment;
        this.previousStatus = previousStatus;
        this.newStatus = newStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id",  nullable = false)
    @Getter
    private Payment payment;

    @Enumerated(EnumType.STRING)
    @Column
    @Getter
    private PaymentStatus previousStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Getter
    private PaymentStatus newStatus;

    @Column(nullable = false)
    @Getter
    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
    }
}
