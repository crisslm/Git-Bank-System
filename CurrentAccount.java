public class CurrentAccount {
    private int accountNumber;
    private int agencyNumber;
    private String clientName;
    private final String CLIENT_BIRTHDAY; 
    private double balance;
    private Login login;

    public CurrentAccount(int accountNumber, int agencyNumber, String clientName, String CLIENT_BIRTHDAY, Login login){
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.clientName = clientName;
        this.CLIENT_BIRTHDAY = CLIENT_BIRTHDAY;
        this.login = login;
        this.balance = 0;
    }

    //GETTERS

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getAgencyNumber() {
        return agencyNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientBirthday() {
        return CLIENT_BIRTHDAY;
    }

    public double getBalance() {
        return balance;
    }

    public Login getLogin() {
        return login;
    }

    //SETTERS

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAgencyNumber(int agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
