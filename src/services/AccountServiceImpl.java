package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Account;
import models.Transaction;

public class AccountServiceImpl implements AccountService {
    
    private Account account;
    private List<Integer> balances = new ArrayList<>() ;
    private int balance = 0 ;

    public AccountServiceImpl(Account account) {
        this.account = account;
    }
    
    @Override
    public void deposit(int amount){
        LocalDate  date = LocalDate.now();
        this.account.addTransaction(new Transaction(amount, date.toString()));
        balances.add(balance += amount);
    }

    @Override
    public void withdraw(int amount){
        LocalDate date = LocalDate.now();
        if (balance >= amount){
            this.account.addTransaction(new Transaction(-amount, date.toString()));
            balances.add(balance -= amount);
        } 
    }

    @Override
    public void printStatement(){
        System.out.println("||Date||Amount||Balance||");
        List<Transaction> transactions = this.account.getTransactions();
        Collections.reverse(transactions);
        Collections.reverse(balances);
        for (int i=0 ; i < transactions.size() ; i++) {
            System.out.println("||"+transactions.get(i).date()+"||"+transactions.get(i).amount()+"||"+ balances.get(i) + "||");
        }
    }
}
