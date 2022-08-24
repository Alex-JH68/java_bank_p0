package Banking;

public class Customer {
    private final String FirstName;
    private final String LastName;
    private final String userName;
    private final String pw;
    private final Account account;

    Customer(String FirstName, String LastName, String userName, String pw, Account account){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.userName = userName;
        this.pw = pw;
        this.account = account;

    }
    @Override
    public String toString(){
        return "Account Name" + FirstName + LastName + account;
    }
    public String info(){
        return "Account Name:"+" " + FirstName +" "+ LastName;
    }
    public String userinfo(){
        return ""+userName;
    }
    public String pwinfo(){
        return ""+pw;
    }
    Account getAccount(){
        return account;

    }
}
