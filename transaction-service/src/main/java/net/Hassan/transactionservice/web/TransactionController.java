package net.Hassan.transactionservice.web;

import net.Hassan.transactionservice.entities.Transaction;
import net.Hassan.transactionservice.repository.TransactionRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TransactionController {
    private TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/transactions")
    public List<Transaction> transactions(){
        return transactionRepository.findAll();
    }
}
