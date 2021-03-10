package bank;

public class Bank {

    //开门 等待用户进来办理业务
    public void profession(Person person){
        System.out.println(person.getName()+"客户进入银行啦");
        person.callNumber();
        person.transact();
        person.leave();
    }

}
