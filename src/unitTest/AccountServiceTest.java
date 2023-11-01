package unitTest;

import models.Client;
import models.Transaction;
import services.AccountServiceImpl;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class AccountServiceTest {
        @Test
        public void testTransactions()
        {
            LocalDate date = LocalDate.now();
            Client client1 = new Client("Mouna", 0);
            AccountServiceImpl accountServiceImpl = new AccountServiceImpl(client1.getAccount());
            List<Transaction> expectedTransactions = new ArrayList<>();
            expectedTransactions.add(new Transaction(1000,date.toString()));
            expectedTransactions.add(new Transaction(2000,date.toString()));
            expectedTransactions.add(new Transaction(-500,date.toString())); 
            accountServiceImpl.deposit(1000);
            accountServiceImpl.deposit(2000);
            accountServiceImpl.withdraw(500);
            assertEquals(expectedTransactions, client1.getAccount().getTransactions());
        }

        @Test
        public void testWithdraw()
        {
            Client client1 = new Client("Mouna", 0);
            AccountServiceImpl accountServiceImpl = new AccountServiceImpl(client1.getAccount());
            LocalDate date = LocalDate.now();
            List<Transaction> expectedTransactions = new ArrayList<>();
            expectedTransactions.add(new Transaction(1000,date.toString()));
            expectedTransactions.add(new Transaction(2000,date.toString()));
            expectedTransactions.add(new Transaction(-3000,date.toString()));
            accountServiceImpl.deposit(1000);
            accountServiceImpl.deposit(2000);
            accountServiceImpl.withdraw(3000);
            assertEquals(expectedTransactions, client1.getAccount().getTransactions());
           
        }

}
