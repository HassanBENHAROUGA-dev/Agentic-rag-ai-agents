package net.Hassan.transactionservice.repository;

import net.Hassan.transactionservice.entities.Transaction;
import net.Hassan.transactionservice.entities.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountId(long accountId);
    List<Transaction> findByStatus(TransactionStatus transactionStatus);
}
