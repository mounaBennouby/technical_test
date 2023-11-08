import models.Client;
import services.AccountServiceImpl;

public class App {
    public static void main(String[] args) throws Exception {
        Client client1 = new Client("Mouna"); 
        AccountServiceImpl accountServiceImpl = new AccountServiceImpl(client1.getAccount());
        accountServiceImpl.deposit(1000);
        accountServiceImpl.deposit(2000);
        accountServiceImpl.withdraw(500);
        accountServiceImpl.printStatement();
    }
}
