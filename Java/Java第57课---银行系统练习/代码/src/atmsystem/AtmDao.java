package atmsystem;

import java.util.HashMap;

public class AtmDao {

    //DAO作为一个层次---持久层   操作数据  读写数据
    //dao中还有一个小弟 负责加载文件 更新文件数据
    private FileLoaderAndCommit flac = new FileLoaderAndCommit("src\\atmsystem\\User.txt");

    //发现登录的方法 每一次调用都需要创建流管道 读取文件的信息
    //内存中操作登录的业务 文件不在一个地方 认为读取的过程很慢
    //想到一个解决方案 创建一个map集合充当缓存 将文件中的数据全都读出来 读一次
    //一行记录 创建一个对象存起来  一个人  一个对象  三个属性
    //集合除了可以充当缓存 增强执行性能以外 还能用来做记录的修改
    private HashMap<String,User> userBox = flac.loadFile();

    //设计一个方法  目的是为了我的所有业务服务
    //有参数  账号名  返回值 一个对象User
    public User selectOne(String aname){
        return userBox.get(aname);//这里是一行 以后如果不是一行的时候 只需要改变这个方法
    }
    //设计一个方法 目的是为了将某一个修改完毕的对象存入集合
    public void update(User user){
        userBox.put(user.getAname(),user);//集合做了修改
        flac.commit(userBox);
    }


}
