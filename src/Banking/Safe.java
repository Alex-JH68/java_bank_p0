package Banking;

public class Safe extends Account{
    Safe(double firstDeposit){
        super();
        this.setBalance(firstDeposit);
}

    @Override
    public String toString(){
        return "Account ID"+ " "+ this.getAccNum() +"  "+ "Balance:" + this.getBalance();
    }
}