import java.util.*;
public class Bank{
    static double balance = 0;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int option =0;
        while(option!=4){
            System.out.println("Welcome to the bank");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Enter an option");

            option=sc.nextInt();
            
            switch (option){
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("Invalid option. Try Again!!!");
                    break;            
            }
        }
    }
    public static void checkBalance(){
        System.out.println("Your Current Balance is: "+balance+"Rs.");
    }
    public static void deposit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to deposit: ");
        double amount=sc.nextDouble();
        balance = balance + amount;
        System.out.println(amount+"Rs. has been deposited o your account.");
    }
    public static void withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to withdraw :");
        double amount = sc.nextDouble();

        if(amount > balance){
            System.out.println("Insufficient Funds!!!");
        }
        else{
            balance = balance - amount;
            System.out.println("Rs. "+amount+" has been withdrawn from your account.");
        }
        checkBalance();
    }
    public static void exit(){
        System.out.println("Thank you for Banking with us. Have a Great day!!!");
    }
}
