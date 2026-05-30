package mx.levm.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.levm.finance.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
