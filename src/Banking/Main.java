package Banking;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    Scanner keyboard = new Scanner(System.in);
    Bank bank = new Bank();
    boolean leaveMenu;

    public static void main(String[] args){
        Main menu = new Main();
        menu.RunMenu();
    }
    public void RunMenu(){
        MenuOpener();
        while(!leaveMenu){
            MenuSelect();
            int inputkey = InputSelect();
            RunSelect(inputkey);

        }

    }

    private void MenuOpener(){
        System.out.println("===========================");
        System.out.println("|    Banking Application  |");
        System.out.println("|        Project 0        |");
        System.out.println("===========================");
    }

    private void MenuSelect(){
        System.out.println("(1)Create Account");
        System.out.println("(2)Make Deposit");
        System.out.println("(3)Make Withdrawal");
        System.out.println("(4)Show Account Information");
        System.out.println("(5) Login as Admin");
        System.out.println("(6) Quit");
    }

    private int InputSelect(){
        int inputkey =-1;
        do {
            System.out.print("Enter an option:");

            try {
                inputkey = Integer.parseInt(keyboard.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input, please select an option");
            }
            if (inputkey < 0 || inputkey > 6) {
                System.out.println("Please enter a number listed");
            }
        }while (inputkey < 0 || inputkey > 6 );
        return inputkey;

    }

    private void RunSelect(int inputkey){
        switch(inputkey){
            case 0:
                System.out.println("Exiting application");
                System.exit(0);
                break;
            case 1:
                MakeAccount();
                break;
            case 2:
                MakeDeposit();

                break;
            case 3:
                MakeWithdraw();

                break;
            case 4:
                DisplayAccount();
                break;
            case 5:
                AdminLogin();
                break;
            case 6:
                System.out.println("Exiting application");
                System.exit(0);
                break;
            default:
                System.out.println("Unknown Error");
        }

    }
    private void MakeAccount(){
        String FirstName, LastName, userName, pw = "";
        double firstDeposit = 0;
        boolean active = false;

        System.out.print("Please enter your First Name");
        FirstName = keyboard.nextLine();
        System.out.print("Please enter your Last Name");
        LastName = keyboard.nextLine();
        System.out.print("Please enter a username");
        userName = keyboard.nextLine();


        while(!active){
            System.out.print("Please deposit an initial amount");
            try {
                firstDeposit = Double.parseDouble(keyboard.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("You must enter a number for the deposit");
            }
            if (firstDeposit <= 0) {
                System.out.println("You must enter a number higher than zero");
            }
            else {
                active = true;
            }
        }
        Account account;
        account = new Safe(firstDeposit);
        Customer customer = new Customer(FirstName,LastName,userName,pw,account);
        bank.newCustomer(customer);


    }

    private void MakeDeposit(){
        int account = UserLogin();
        if (account >=0){
            System.out.print("How much will you deposit?:");
            double amount =0;
            try {
                amount = Double.parseDouble(keyboard.nextLine());

            }
            catch (NumberFormatException e){
                amount = 0;
            }
            bank.getCustomer(account).getAccount().deposit(amount);
        }

    }

    private void MakeWithdraw(){
        int account = UserLogin();
        if (account >=0){
            System.out.print("How much will you withdraw?:");
            double amount =0;
            try {
                amount = Double.parseDouble(keyboard.nextLine());

            }
            catch (NumberFormatException e){
                amount = 0;
            }
            bank.getCustomer(account).getAccount().withdraw(amount);
        }

    }

    private void DisplayAccount(){
        int account = UserLogin();
        if (account>=0){
            System.out.println(bank.getCustomer(account).getAccount());
        }else{
            System.out.println("Invalid Selection");
        }

    }

    private void AdminLogin(){


    }
    private int UserLogin(){

        ArrayList<Customer> customers = bank.getCustomers();
        if (customers.size()<=0){
            System.out.println("No registered Users");
            return -1;
        }

        System.out.println("Select an Account:");
        for (int i=0; i<customers.size();i++){
            System.out.println("("+(i+1)+")"+customers.get(i).info());
        }
        int account = 0;
        System.out.println("Choose the account number:");

        try{
            account = Integer.parseInt(keyboard.nextLine())-1;
        } catch (NumberFormatException e){
            account = -1;
        }

        return account;



    }



}

