package models;

import java.util.ArrayList;
import java.util.List;

public class Account{

    private List<Transaction> transactions = new ArrayList<>();


    public List<Transaction> getTransactions()
    {
        return this.transactions;
    }

    public void addTransaction(Transaction transaction)
    {
        this.transactions.add(transaction);
    }

}