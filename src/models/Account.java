package models;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountNumber;
    private AccountType accountType;
    private double balance;
    private Customer customer;
    private List<Transaction> transactionHistory;
    private boolean isActive;

    public enum AccountType{
        SAVINGS,
        CHECKING,
        BUSINESS
    }

    public Account(String accountNumber, AccountType accountType, Customer customer, double initialDeposit){
        this.accountNumber =accountNumber;
        this.accountType=accountType;
        this.customer=customer;
        this.balance =initialDeposit;
        this.transactionHistory=new ArrayList<>();
        this.isActive=true;
    }

    public boolean deposit(double amount){
        if(amount <=0){
            System.out.println("Deposit amount must be positive.");
            return false;
        }

        if(!isActive){
            System.out.println("Account is inactive. Cannot perform deposit.");
            return false;

        }
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) throws exceptions.InsufficientFundsException{

        if(amount<=0){
            System.out.println("withdrawal amount must be positive.");
            return false;
        }

        if(!isActive){
            System.out.println("Account is inactive. cannot perform withdrawal");
            return false;
        }

        if(this.balance< amount){
            throw new exceptions.InsufficientFundsException(
                "Insufficient funds. Avialable balance: $"+this.balance
            );
        }

        this.balance-= amount;
        return true;

    } 
    
   public void addTransaction(Transaction transaction){
    this.transactionHistory.add(transaction);
   }

   public List<Transaction> getTransactionHistory(){
    return new ArrayList<>(transactionHistory);
   }

   public void deactivateAccount(){
    this.isActive=true;
   }

   public String getAccountNumber(){
    return accountNumber;
   }

   public double getBalance(){
    return balance;
    
   }

   public Customer getCustomer(){
    return customer;
   }

   public boolean isActive(){
    return isActive;
   }

   @Override
    public String toString() {
        return String.format("Account[Number=%s, Type=%s, Balance=$%.2f, Active=%s, Owner=%s]",
                accountNumber, accountType, balance, isActive, customer.getName());
    }
        
}
