package Banking;

public class Account {
    private double balance;
    private int accID;
    private static int accnumBIG= 1000000000;
    Account(){
        accID = accnumBIG ++;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public int getAccNum(){
        return accID;
    }
    public void withdraw(double amount){
        if (amount > balance){
            System.out.println("You do not have enough funds");
        }
        balance -= amount;
        System.out.println("You have withdrawn" + amount + "dollars");
        System.out.println("Your current balance is" + balance);
    }
    public void deposit(double amount){
        if (amount < 0){
            System.out.println("You cannot make a negative deposit");
        }
        balance += amount;
        System.out.println("You have deposited" + amount + "dollars");
        System.out.println("Your current balance is" + balance);
    }
}
