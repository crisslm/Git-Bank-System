import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem{

    public static void withdraw(CurrentAccount user, double value){
        if(value > user.getBalance()){
            System.out.println("Balance isn't enough!\nYou have: " + user.getBalance());
        } else{
            double total = user.getBalance() - value;
            user.setBalance(total);
            System.out.println("Withdraw perfectly done!\nTou have: " + user.getBalance());
        }
    }

    public static void transfer(CurrentAccount user1, CurrentAccount user2, double value){
        if(value > user1.getBalance()){
            System.out.println("Balance isn't enough!\nYou have: " + user1.getBalance());
        } else{
            double balanceUser1 = user1.getBalance() - value;
            double balanceUser2 = user2.getBalance() + value;
            user1.setBalance(balanceUser1);
            user2.setBalance(balanceUser2);
        }
    }

    public static void viewBalance(CurrentAccount user){
        System.out.println("Your balance: " + user.getBalance());
    }

    public static String cancelAccount(ArrayList<CurrentAccount> list, CurrentAccount user, String Justify){
        list.remove(user);
        return Justify;
    }

    public static CurrentAccount findByUserName(ArrayList<CurrentAccount> list, String userName1){
        for(CurrentAccount account : list){
            if((account.getLogin().getUserName()).equals(userName1)){
                return account;
            }
        }
        return null; // Account not found
    }

    public static boolean sameUsercheck(ArrayList<CurrentAccount> list, String userName){
        for(CurrentAccount account : list){
            if((account.getLogin().getUserName()).equals(userName)){
                return true;
            }
        }
        return false;
    }

    public static int createAccountNumber(){
        int min = 1;
        int max = 1000000000;
        int randomIntInRange = (int)(Math.random() * (max - min + 1) + min);
        return randomIntInRange;
    }
    
    public static void greetings(){
        System.out.println("WELCOME TO GIT BANK!");
        System.out.println("---------------------\n");
    }

    public static void loginOptions(){
        System.out.println("Choose an option bellow: \n1)Login.\n2)Create a new account.\n");
        System.out.print("Enter here: ");
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<CurrentAccount> users = new ArrayList<>(); // "DataBase"

        int answerLoginOptions;
        greetings();
        loginOptions();
        answerLoginOptions = sc.nextInt();
        while(true){
            switch(answerLoginOptions){
                case 1: //Login
                    System.out.print("Insert your login: ");
                    String userName2 = sc.next();
                    CurrentAccount actualUser = findByUserName(users, userName2);
                    if(actualUser == null){
                        System.out.println("User not found!\n");
                        loginOptions();
                        answerLoginOptions = sc.nextInt();
                        break;
                    } else{
                        System.out.println("Welcome back, " + actualUser.getClientName() + "!");
                    }
                    break;

                case 2: //Create a new account
                    String newUser;
                    String newPassword;
                    boolean sameUser;

                    System.out.print("Create a new user: ");
                    newUser = sc.next();
                    sameUser = sameUsercheck(users, newUser);
                    if(sameUser){
                        System.out.print("This user already exists.\n");
                        break;
                    }

                    System.out.print("Create a password: ");
                    newPassword = sc.next();
                    
                    Login newLogin = new Login(newUser, newPassword);

                    System.out.print("Put your name: ");
                    String newName = sc.next();

                    System.out.print("What year were you born (dd/mm/yyyy): ");
                    String date = sc.next();

                    int newAccountNumber = createAccountNumber();
                    CurrentAccount newAccount = new CurrentAccount(newAccountNumber, 1001, newName, date, newLogin);

                    users.add(newAccount);
                    System.out.println("\nAccount succesfully created!\n");
                    System.out.println("Know just login!\n");
                    loginOptions();
                    answerLoginOptions = sc.nextInt();

                    break;

                default: 
                    System.out.println("\nInvalid option, try again: ");
                    loginOptions();
                    answerLoginOptions = sc.nextInt();
                    break;
            }
        }


    }
}
