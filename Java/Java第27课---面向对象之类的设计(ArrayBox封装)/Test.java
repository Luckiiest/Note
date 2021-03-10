public class Test {

    public static void main(String[] args){
        //相当于是用户(你们)
        //想要存储元素----->第一个是数组[]  第二个是ArrayBox
        //1.创建一个box对象
        ArrayBox<Integer> box = new ArrayBox<Integer>(6);//存储以后长度还能改变
        //2.让box干活去  存储一个元素(int-->小椅子)
        for(int i=1;i<=6;i++){
            box.add(i*10);
        }//10 20 30 40 50 60 0 0 0 0
        System.out.println("有效元素个数:"+box.size());//6
        //3.获取第全部元素
        for(int i=0;i<box.size();i++){
            int value = box.get(i);
            System.out.print(value+" ");//10 20 30 40 50 60
        }
        System.out.println();
        //4.删除2号索引位置的元素
        int removeValue = box.remove(2);
        System.out.println(removeValue);//30
        System.out.println(box.size());//5
        for(int i=0;i<box.size();i++){
            int value = box.get(i);
            System.out.print(value+" ");//10 20 40 50 60
        }

    }
}
