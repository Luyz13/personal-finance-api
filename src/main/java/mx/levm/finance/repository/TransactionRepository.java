package mx.levm.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.levm.finance.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
