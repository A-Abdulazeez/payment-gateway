package az.dev.paymentgateway.payment.repository;

import az.dev.paymentgateway.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
