package computer;

public class Test {
    public static void main(String[] args){
        MachineRoom room = new MachineRoom();
        Student student1 = new Student("郑中拓");
        room.welcomeStudent(student1);
        Student student2 = new Student("张三");
        room.welcomeStudent(student2);
        Student student3 = new Student("李四");
        room.welcomeStudent(student3);
        Student student4 = new Student("王五");
        room.welcomeStudent(student4);
        Student student5 = new Student("赵六");
        room.welcomeStudent(student5);
        Student student6 = new Student("钱七");
        room.welcomeStudent(student6);
    }
}
