package atmsystem;


public class AtmService {

    //这一个类都是负责处理业务逻辑  需要底层数据的支持
    private AtmDao dao = new AtmDao();

    //网络银行的业务
    //所有的业务方法 按照我们之前的优化结构设计
    //只有业务逻辑  判断 比较 计算等等
    //看不见任何数据的操作  从哪儿查出来的 存在哪儿
    //设计一个业务方法  登录
    public String login(String aname,String apassword){
        User user = dao.selectOne(aname);
        if(user!=null && user.getApassword().equals(apassword)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }
    //设计一个业务方法  查询余额
    public Float queryBalance(String aname){
        User user = dao.selectOne(aname);
        return user.getAbalance();
    }
    //设计一个业务方法  存款  数据库中做修改 某一行记录
    public void deposit(String aname,Float depositMoney){
        //先将集合内的数据做修改  找到某一个user对象 对象中的balance属性修改
        User user = dao.selectOne(aname);
        user.setAbalance(user.getAbalance()+depositMoney);
        dao.update(user);
        //dao.commit();//提交  将临时的数据永久的写入文件  事务
    }
    //设计一个业务方法  取款
    public void withdrawal(String aname,Float withdrawalMoney){
        //先将集合内的数据做修改  找到某一个user对象 对象中的balance属性修改
        User user = dao.selectOne(aname);
        if(user.getAbalance()>withdrawalMoney){
            user.setAbalance(user.getAbalance()-withdrawalMoney);
            dao.update(user);
            //this.commit();//提交  将临时的数据永久的写入文件  事务
        }else{
            System.out.println("对不起"+aname+",您的账户余额不足");
        }
    }
    //设计一个业务方法  转账
    public void transfer(String outName,String inName,Float transferMoney){
        //先将集合内的数据做修改  找到某一个user对象 对象中的balance属性修改
        User outUser = dao.selectOne(outName);
        if(outUser.getAbalance()>transferMoney){
            User inUser = dao.selectOne(inName);
            if(inUser!=null){//转入账户是存在的
                outUser.setAbalance(outUser.getAbalance()-transferMoney);
                inUser.setAbalance(inUser.getAbalance()+transferMoney);
                dao.update(outUser);
                //this.update(inUser);
                //this.commit();//提交  将临时的数据永久的写入文件  事务
            }else{
                System.out.println("对不起,您输入的转入账户不存在");
            }
        }else{
            System.out.println("对不起"+outName+",您的账户余额不足");
        }
    }
}
