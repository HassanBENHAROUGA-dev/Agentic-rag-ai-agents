package net.Hassan.transactionservice.agents;

import dev.langchain4j.agent.tool.Tool;
import lombok.extern.slf4j.Slf4j;
import net.Hassan.transactionservice.entities.Transaction;
import net.Hassan.transactionservice.entities.TransactionStatus;
import net.Hassan.transactionservice.repository.TransactionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class TransactionAiTools {
    private TransactionRepository transactionRepository;

    public TransactionAiTools(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Tool("Get All Transactions")
    public List<Transaction> getAllTransactions(){

        return transactionRepository.findAll();
    }

    @Tool("Get All Transactions By Account ID")
    public List<Transaction> getAllTransactionsByAccountId(Long accountId){
        return transactionRepository.findByAccountId(accountId);
    }

    @Tool("Update the Transaction Status By ID")
    public Transaction UpdateTransactionStatus(Long transactionid, TransactionStatus transactionStatus){

        Transaction transaction = transactionRepository.findById(transactionid).get();
        transaction.setStatus(transactionStatus);
        transactionRepository.save(transaction);

        return transaction;
    }
}
