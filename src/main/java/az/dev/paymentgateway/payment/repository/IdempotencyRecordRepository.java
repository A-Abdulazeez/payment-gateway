package az.dev.paymentgateway.payment.repository;

import az.dev.paymentgateway.payment.entity.IdempotencyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdempotencyRecordRepository extends JpaRepository<IdempotencyRecord, Long> {
}
