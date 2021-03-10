package myselfannotation;

public class User {//Atm系统 一个账号

    private String username;
    private String password;
    private Float balance;

    @MyAnnotation({"zhangsan","333","1333.33"})
    public User(){}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Float getBalance() {
        return balance;
    }
    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
