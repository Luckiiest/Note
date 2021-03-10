public class TestFunctions {

    //*10.设计一个方法 用来实现用户登录认证(二维数组当作小数据库)
    //      是否需要条件? 需要提供账号名和密码  需要返回值 登录成功与否的结果

    //1.需要有小数据库---存储用户真实的账号和密码
    private String[][] userBox = {{"郑中拓","123456"},{"渡一教育","666666"},{"Java","888"}};
    public String login(String user,String password){
        //4.进行校验
        String result = "用户名或密码错误";
        for(int i=0;i<userBox.length;i++){
            if(userBox[i][0].equals(user)){
                if(userBox[i][1].equals(password)){
                    result = "登录成功";
                }
                break;
            }
        }
        return result;
    }


    //9.设计一个方法  给数组进行排序(既能升序又能降序)
    //      是否需要提供条件---数组 提供一个排序的规则boolean  返回值---不用
    //      flag==true升序排列   flag==false降序排列
    public void orderArray(int[] array,boolean flag){
        for(int i=1;i<array.length;i++){//控制执行的轮次---数组的长度
            for(int j=array.length-1;j>=i;j--){//控制比较4次
                //什么情况下可以进行元素的互换
                // (flag==true && array[j]<array[j-1]) || (flag==false && array[j]>array[j-1])
                if((flag==true && array[j]<array[j-1]) || (flag==false && array[j]>array[j-1])){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }



    //8.设计一个方法  用来存储给定范围内的素数(2-100) 素数在自然数之内
    //      是否需要提供条件  begin end   返回值一个装满了素数的数组
    public int[] findPrimeNum(int begin,int end){
        if(begin<0 || end<0){
            System.out.println("素数没有负数 不给你找啦");
            return null;//自定义一个异常  认为规定的一种不正常的现象
        }
        if(begin>=end){
            System.out.println("您提供的范围有误 begin应该比end要小");
            return null;//自定义一个异常  认为规定的一种不正常的现象
        }
        //创建一个足够长的数组
        int[] array = new int[(end-begin)/2];
        int index = 0;//记录新数组的索引变化   同时记录个数
        for(int num=begin;num<=end;num++){
            boolean b = false;//标记
            for(int i=2;i<=num/2;i++){
                if(num%i==0){
                    b = true;
                    break;
                }
            }
            if(!b){
                array[index++] = num;
            }
        }
        //将数组后面的多余的0去掉
        int[] primeArray = new int[index];
        for(int i=0;i<primeArray.length;i++){
            primeArray[i] = array[i];
        }
        array = null;
        return primeArray;
    }

    //扩展 设计一个方法  将给定的元素插入数组的某一个位置
    //7.设计一个方法  用来去掉数组中的0元素
    //      需要提供参数一个数组  需要提供删除的元素是什么    返回值 一个新的数组
    public int[] removeElementFromArray(int[] array,int element){
        //找寻原数组中去掉被删除元素后的长度
        int count = 0;//记录非删除元素的个数
        for(int i=0;i<array.length;i++){
            if(array[i]!=element){
                count++;
            }
        }
        //通过找到的count创建一个新数组
        int[] newArray = new int[count];
        int index = 0;//控制新数组的索引变化
        //将原来数组中非删除的元素存入新数组中
        for(int i=0;i<array.length;i++){
            if(array[i]!=0){
                newArray[index++] = array[i];
            }
        }
        //将新数组返回
        return newArray;
    }

    //5.设计一个方法  用来合并两个数组
    //      是否需要参数  需要提供两个数组   需要返回一个大的数组
    public int[] mergeArray(int[] a,int[] b){
        //创建一个新的数组
        int[] newArray = new int[a.length+b.length];
        //分别将a和b数组的元素存入新数组内
        for(int i=0;i<a.length;i++){
            newArray[i] = a[i];
        }
        for(int i=0;i<b.length;i++){
            newArray[a.length+i] = b[i];
        }
        //将新数组返回
        return newArray;
    }

    //6.设计一个方法  用来将一个数组按照最大值位置拆分
    //      需要提供一个大的数组  需要返回值二维数组
    public int[][] splitArray(int[] array){// 1 2 3 9 4 5
        //找寻最大值索引位置
        int max = array[0];//记录最大值
        int index = 0;//记录最大值的索引位置
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                max = array[i];
                index = i;
            }
        }
        //通过找寻到的index判定数组拆分后的前后长度
        int[] newa = new int[index];
        int[] newb = new int[array.length-index-1];
        //分别将两个小数组填满
        for(int i=0;i<newa.length;i++){
            newa[i] = array[i];
        }
        for(int i=0;i<newb.length;i++){
            newb[i] = array[(index+1)+i];
        }
        //将两个新的小数组一起返回
        return new int[][]{newa,newb};
    }

    //4.设计一个方法  用来找寻给定的元素是否在数组内存在(Scanner输入一个)
    //      是否需要参数及返回值   需要提供一个数组  需要一个目标元素   返回值告诉你是否找到啦
    // 方法设计了返回值类型  就必须给返回值  编译检测的悲观性原则
    public String isExist(int[] array,int element){
        //循环方式找寻是否存在
        String result = "对不起 您要的值在数组中没有";
        for(int i=0;i<array.length;i++){
            if(array[i]==element){
                result = "恭喜您 您要的值在数组中存在";
                break;
            }
        }
        return result;
    }

    //3.设计一个方法  用来寻找数组中的极值(最大值 或 最小值)
    //      是否需要参数及返回值   需要提供一个数组  需要提供一个值(最大 最小)   返回值肯定需要一个值
    public int findMaxOrMinNum(int[] array,boolean flag){//flag==true最大值  flag==false最小值
        //2.找一个变量
        int temp = array[0];
        //3.利用遍历数组的方式挨个与max比较
        for(int i=1;i<array.length;i++){
            if(flag && array[i]>temp){//找寻最大值
                    temp = array[i];
            }else if(!flag && array[i]<temp){//找寻最小值
                    temp = array[i];
            }
        }
        //3.将找到的值返回
        return temp;
    }

    //*2.设计一个方法  用来交换一个数组(头尾互换)
    //      是否需要参数及返回值   需要提供一个数组   不需要返回值
    public void changeArrayElements(int[] array){
        //2.数组内部的元素头尾对应互换
        for(int i=0;i<array.length/2;i++){
            int temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
    }

}
