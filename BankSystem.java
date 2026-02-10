import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankSystem{

    public static void withdraw(CurrentAccount user, double value){
        if(value > user.getBalance()){
            System.out.println("Balance isn't enough!\nYou have: " + user.getBalance());
        } else{
            double total = user.getBalance() - value;
            user.setBalance(total);
            System.out.println("Withdraw perfectly done!\nou have: " + user.getBalance());
            System.out.println("\nMoney taken sucessfully! ");
        }
    }

    public static void receive(CurrentAccount user, double value){
        double total = user.getBalance() + value;
        user.setBalance(total);
        System.out.println("Receive perfectly done!\nYou have: " + user.getBalance());
    }

    //User1 transfer to User2
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

    public static void viewAccountNumber(CurrentAccount user){
        System.out.println("\nYour account number: " + user.getAccountNumber());
    }

    public static void viewBalance(CurrentAccount user){
        System.out.println("\nYour balance: R$" + user.getBalance() + "\n");
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

    public static CurrentAccount findByAccountNumber(ArrayList<CurrentAccount> list, int accountNumber){
        for(CurrentAccount account : list){
            if(account.getAccountNumber() == accountNumber){
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

    public static void showMenuOptions(){
        System.out.println("Actions availables: \n1)Withdraw\n2)Receive\n3)Transference\n4)Cancel account\n5)Exit\n"); //Maybe will be more options...
        System.out.print("Enter here: ");
    }

    /**
     * @param args
     */
    public static void main(String [] args){
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<CurrentAccount> users = new ArrayList<>(); // "DataBase"

            int answerLoginOptions;
            greetings();
            while(true){
                try{
                    loginOptions();
                    answerLoginOptions = sc.nextInt();
                    break;
                }
                catch(InputMismatchException e){
                    sc.next();
                    System.out.println("\nWrong Input type, try again.\n\n");
                }
            }
            while(true){
                switch(answerLoginOptions){
                    case 1 -> {
                        //Login
                        System.out.print("Insert your user: ");
                        String userName2 = sc.next();
                        CurrentAccount actualUser = findByUserName(users, userName2);
                        if(actualUser == null){
                            System.out.println("User not found!\n");
                            while(true){
                                try{
                                    loginOptions();
                                    answerLoginOptions = sc.nextInt();
                                    break;
                                }
                                catch(InputMismatchException e){
                                    sc.next();
                                    System.out.println("\nWrong Input type, try again.\n\n");
                                }
                            }
                            break;
                        } else{
                            System.out.print("Put your password: ");
                            String userPassword = sc.next();
                            if(!userPassword.equals(actualUser.getLogin().getPassword())){
                                System.out.println("\nWrong Password! Try again: \n");
                                while(true){
                                    try{
                                        loginOptions();
                                        answerLoginOptions = sc.nextInt();
                                        break;
                                    }
                                    catch(InputMismatchException e){
                                        sc.next();
                                        System.out.println("\nWrong Input type, try again.\n\n");
                                    }
                                }
                                break;
                            } else{
                                int menuOptions;
                                System.out.println("Welcome back, " + actualUser.getClientName() + "!\n");
                                viewAccountNumber(actualUser);
                                viewBalance(actualUser);
                                showMenuOptions();
                                menuOptions = sc.nextInt();
                                while(menuOptions != 99){
                                    switch(menuOptions){
                                        case 1 -> {
                                            //Withdraw
                                            System.out.print("\nHow much would you like to take?: ");
                                            double value = sc.nextDouble();
                                            withdraw(actualUser, value);
                                            System.out.println("\nYour actual balance: " + actualUser.getBalance() + "\n");
                                            while(true){
                                                try {
                                                    showMenuOptions();
                                                    menuOptions = sc.nextInt();
                                                    break;
                                                } 
                                                catch(InputMismatchException e){
                                                    sc.next();
                                                    System.out.println("\nWrong input type, try again.\n\n");
                                                }
                                            }
                                        }
                                        
                                        case 2 -> {
                                            //Receive
                                            System.out.print("\nHow much would you like to receive?:");
                                            double value2 = sc.nextDouble();
                                            receive(actualUser, value2);
                                            System.out.println("\nMoney received sucessfully! ");
                                            System.out.println("\nYour actual balance: " + actualUser.getBalance() + "\n");
                                            while(true){
                                                try {
                                                    showMenuOptions();
                                                    menuOptions = sc.nextInt();
                                                    break;
                                                } 
                                                catch(InputMismatchException e){
                                                    sc.next();
                                                    System.out.println("\nWrong input type, try again.\n\n");
                                                }
                                            }
                                        }

                                        case 3 -> {
                                            //Transfer
                                            System.out.println("Put the account number\nthat will receive.\n");
                                            System.out.print("Account number: ");
                                            int accountNumber = sc.nextInt();
                                            CurrentAccount accountToReceive = findByAccountNumber(users, accountNumber);
                                            if(accountToReceive == null){
                                                System.out.println("Account not found! ");
                                                break;
                                            }
                                            System.out.print("How much do you want to transfer: USD$");
                                            double value3 = sc.nextDouble();
                                            transfer(actualUser, accountToReceive, value3);
                                            System.out.println("\nMoney transferred sucessfully! ");
                                            System.out.println("\nYour actual balance: " + actualUser.getBalance() + "\n");

                                            while(true){
                                                try {
                                                    showMenuOptions();
                                                    menuOptions = sc.nextInt();
                                                    break;
                                                } 
                                                catch(InputMismatchException e){
                                                    sc.next();
                                                    System.out.println("\nWrong input type, try again.\n\n");
                                                }
                                            }
                                        }
                                            
                                        case 4 -> {
                                            //Cancel Account
                                            System.out.print("Tell us, why do you want to cancel your account?: ");
                                            String justify = sc.next();
                                            justify = cancelAccount(users, actualUser, justify);
                                            System.out.println("\nAccount canceled sucessfully!\n ");
                                            System.out.println("Your justify: " + justify);
                                            menuOptions = 99;
                                        }

                                        case 5 -> {
                                            //Exit
                                            System.out.println("\nExiting... \n");
                                            menuOptions = 99;
                                        }

                                        default -> {
                                            System.out.println("\nInvalid option, try again: ");
                                            while(true){
                                                try {
                                                    showMenuOptions();
                                                    menuOptions = sc.nextInt();
                                                    break;
                                                } 
                                                catch(InputMismatchException e){
                                                    sc.next();
                                                    System.out.println("\nWrong input type, try again.\n\n");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        while(true){
                            try{
                                loginOptions();
                                answerLoginOptions = sc.nextInt();
                                break;
                            }
                            catch(InputMismatchException e){
                                sc.next();
                                System.out.println("\nWrong Input type, try again.\n\n");
                            }
                        }
                    }

                    case 2 -> {
                        //Create a new account
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
                        CurrentAccount sameAccountNumber = findByAccountNumber(users, newAccountNumber);
                        while(sameAccountNumber != null){
                            newAccountNumber = createAccountNumber();
                            sameAccountNumber = findByAccountNumber(users, newAccountNumber);
                        } 
                        CurrentAccount newAccount = new CurrentAccount(newAccountNumber, 1001, newName, date, newLogin);

                        users.add(newAccount);
                        System.out.println("\nAccount succesfully created!\n");
                        System.out.println("Now just login!\n");
                        while(true){
                            try{
                                loginOptions();
                                answerLoginOptions = sc.nextInt();
                                break;
                            }
                            catch(InputMismatchException e){
                                sc.next();
                                System.out.println("\nWrong Input type, try again.\n\n");
                            }
                        }
                    }

                    default -> { 
                        System.out.println("\nInvalid option, try again: ");
                        while(true){
                            try{
                                loginOptions();
                                answerLoginOptions = sc.nextInt();
                                break;
                            }
                            catch(InputMismatchException e){
                                sc.next();
                                System.out.println("\nWrong Input type, try again.\n\n");
                            }
                        }
                    }
                }
            }
        }
    }
}

