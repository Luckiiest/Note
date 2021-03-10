package myselfannotation;


public class TestMain {

    public static void main(String[] args){
        //获取一个Person类型的对象
        //Person p = new Person();
        //p.setName("郑中拓");
        //p.setAge(18);
        //p.setSex("男");
        //System.out.println(p.getName()+"--"+p.getAge()+"--"+p.getSex());
        //Person p = new Person("郑中拓",18,"男");
        //System.out.println(p.getName()+"--"+p.getAge()+"--"+p.getSex());
        //都是自己创建对象

        //获取一个Person对象 不用自己处理 跟别人要 MySpring
        //对象的创建权利反转(IOC) 赋值(自动DI) 别人处理
        MySpring ms = new MySpring();//管理者 帮我们创建对象 自动赋值

        Question question = (Question)ms.getBean("myselfannotation.Question");
        System.out.println(question.getTitle()+"--"+question.getAnswer());

//        User user = (User)ms.getBean("myselfannotation.User");
//        System.out.println(user.getUsername()+"--"+user.getPassword()+"--"+user.getBalance());

//        Person p = (Person)ms.getBean("myselfannotation.Person");
//        System.out.println(p.getName()+"--"+p.getAge()+"--"+p.getSex());


//        try {
//            //获取Person类中 方法上面的注解信息 反射
//            Class clazz = Class.forName("myselfannotation.Person");
//            Method method = clazz.getMethod("eat");
//            Annotation a = method.getAnnotation(MyAnnotation.class);
//            Class aclazz = a.getClass();
//            Method amethod = aclazz.getMethod("value");
//            String[] values = (String[])amethod.invoke(a);
//            for(String v:values){
//                System.out.println(v);
//            }
//
////            //获取Person类中 属性上面的注解信息  需要用到反射技术
////            //1.获取Person对应的类Class
////            Class clazz = Person.class;
////            //2.通过clazz获取里面的属性
////            Field field = clazz.getDeclaredField("name");
////            //3.通过filed获取上面的注解对象
////            Annotation a = field.getAnnotation(MyAnnotation.class);
////            //4.利用反射执行a中的value方法
////            Class aclazz = a.getClass();//a对象获取它对应的class
////            //5.通过aclazz获取里面的value方法
////            Method amethod = aclazz.getMethod("value");
////            //6.执行value的方法 获取传递的信息
////            String[] values = (String[])amethod.invoke(a);
////            //7.展示一下values内的信息
////            for(String value:values){
////                System.out.println(value);
////            }
////
////            //正常的对象调用执行过程
//////            MyAnnotation a = (MyAnnotation)field.getAnnotation(MyAnnotation.class);
//////            //4.利用a对象执行一下value方法  帮我们搬运过来啦
//////            String[] values = a.value();
//////            System.out.println(values[0]);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
