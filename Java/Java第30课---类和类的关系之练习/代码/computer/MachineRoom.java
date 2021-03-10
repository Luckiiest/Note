package computer;

public class MachineRoom {

    //机房--电脑   聚合关系   机房内有电脑     聚集
    //数组--存放5台电脑   Computer[]
    public Computer[] computers = new Computer[5];//电脑数组

    //设计一个程序块  用来给电脑数组进行初始化(赋值)
    {
        for(int i=0;i<computers.length;i++){
            computers[i] = new Computer(i+1);
        }
    }

    //机房--学生   依赖关系   机房欢迎学生来使用
    public void welcomeStudent(Student student){
        String studentName = student.getName();
        System.out.println("欢迎"+studentName+"学生进入机房");
        //学生进入机房后 挨个找寻 选择一台状态为关闭的电脑
        for(int i=0;i<computers.length;i++){
            boolean computersState = computers[i].isUsed();//找寻某一台电脑 获取他的状态
            if(!computersState){//表示电脑没有人使用
                student.useComputer(computers[i]);
                break;
            }
        }
    }
}
