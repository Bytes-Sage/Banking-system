package services;

import models.Account;
import models.Transaction;
import models.Transaction.TransactionType;
import java.util.UUID;

public class TransactionService {
    

    public Transaction createDepositTransaction(Account account, double amount) {
        String transactionId = generateTransactionId();
        Transaction transaction = new Transaction(
            transactionId,
            account.getAccountNumber(),
            TransactionType.DEPOSIT,
            amount,
            account.getBalance(),
            "Deposit to account"
        );
        
        account.addTransaction(transaction);
        return transaction;
    }

    public Transaction createWithdrawalTransaction(Account account, double amount) {
        String transactionId = generateTransactionId();
        Transaction transaction = new Transaction(
            transactionId,
            account.getAccountNumber(),
            TransactionType.WITHDRAWAL,
            amount,
            account.getBalance(),
            "Withdrawal from account"
        );
       
        account.addTransaction(transaction);
        return transaction;
    }

    public Transaction createTransferOutTransaction(Account fromAccount, String toAccountNumber, double amount) {
        String transactionId = generateTransactionId();
        Transaction transaction = new Transaction(
            transactionId,
            fromAccount.getAccountNumber(),
            TransactionType.TRANSFER_OUT,
            amount,
            fromAccount.getBalance(),
            "Transfer to account " + toAccountNumber
        );
        fromAccount.addTransaction(transaction);
        return transaction;
    }

    public Transaction createTransferInTransaction(Account toAccount, String fromAccountNumber, double amount) {
        String transactionId = generateTransactionId();
        Transaction transaction = new Transaction(
            transactionId,
            toAccount.getAccountNumber(),
            TransactionType.TRANSFER_IN,
            amount,
            toAccount.getBalance(),
            "Transfer from account " + fromAccountNumber
        );
        
        toAccount.addTransaction(transaction);
        return transaction;
    }

    private String generateTransactionId() {
        return "TXN" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public void displayTransaction(Transaction transaction) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(transaction.getFormattedDetails());
        System.out.println("=".repeat(50));
    }
}