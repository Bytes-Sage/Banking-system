package models;

import java.security.PublicKey;
import java.time.LocalDateTime;

public class Transaction {

    private String transactionId;
    private String accountNumber;
    private TransactionType type;
    private double amount;
    private LocalDateTime timestamp;
    private double balanceAfter;
    //optional description or notes
    private String description;

    public enum TransactionType{
        DEPOSIT,
        WITHDRAWAL,
        TRANSFER_IN,
        TRANSFER_OUT,
    }

    public Transaction(String transactionId, String accountNumber, TransactionType type, double amount, double balanceAfter, String description){
        this.transactionId=transactionId;
        this.accountNumber=accountNumber;
        this.type=type;
        this.amount =amount;
        this.timestamp = LocalDateTime.now();
        this.balanceAfter= balanceAfter;
        this.description = description;
    }

    public String getFormattedDetails(){
        return String.format(
            "Transaction ID: %s\n" + 
            "Type: %s\n" +
            "Amount: $%.2f\n" +
            "Date: %s\n" +
            "Balance After: $%.2f\n" + 
            "Description: %s",

            transactionId, type, amount, timestamp, balanceAfter, description

        );
    }

    //getters 
    public String getTransactionId(){
        return transactionId;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public TransactionType getType(){
        return type;
    }

    public double getAmount(){
        return amount;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public double getBalanceAfter(){
        return balanceAfter;
    }

    public String getDescription(){
        return description;
    }
    
    @Override

    public String toString(){
        return String.format("Transaction[ID=%s, Type=%s, Amount=$%.2f, Date=%s]", transactionId,type,amount,timestamp);
    }
}
