package models;

public class Client {
    private String name;
    private Account account;

    public Client(String name){
        this.name = name;
        this.account = new Account();
    }

    public String getName()
    {
        return this.name;
    }

    public Account getAccount()
    {
        return this.account;
    }

}
