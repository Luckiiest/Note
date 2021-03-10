public class ArrayBox<E> {//泛型
    //描述事物
    //属性
    // 一间小教室
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;//长度一旦确定不能再次发生改变
    private int size = 0;//记录教室中有效的元素个数

    public ArrayBox(){
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public ArrayBox(int capacity){
        elementData = new Object[capacity];
    }

    //你们是使用者(用户)           我是ArrayBox类型的一个具体的对象
    //想要存储椅子                 你们把椅子直接交给我box
    //以前直接找到数组那个人       我就可以帮你们存起来啦
    //存储的时候你们自己找位置     至于我把椅子存在了哪里 长度够不够 都不用你们管
    //如果数组存满啦自己想办法

    //方法
    //设计方法 帮忙判断给定index范围是否合法  小D同学
    //      需要提供一个index
    private void rangeCheck(int index){
        if(index<0 || index>=size){
            //参考数组的操作  自己定义一个异常(自己创建的类)来说明这个问题
            throw new BoxIndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
    }
    //设计方法 帮我自己做事的 小A同学
    //      需要提供一个条件  老师需要的最小容量
    //      没有返回值
    private void ensureCapacityInternal(int minCapacity){
        if(minCapacity - elementData.length > 0){
            //证明老师需要的最小容量 比原来教室的容量还要大 存不下啦
            //扩容---> 小B同学
            this.grow(minCapacity);
        }
    }
    //设计方法 帮助教室扩容(新教室) 小B同学--数学很好但倔强的天才
    //      需要提供一个条件  老师需要的最小容量
    private void grow(int minCapacity){
        //获取旧教室的长度
        int oldCapacity = elementData.length;
        //小B同学 做了一个觉得很好的算法  旧教室1.5倍扩容
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        //若按照这个很好的算法扩容后  所需要的空间还不够 直接利用minCapacity
        if(newCapacity - minCapacity < 0){
            newCapacity = minCapacity;//将老师提供的赋值给newCapacity
        }
        //经过一通计算  最终获取到一个合理的长度 newCapacity
        //按照这个新的长度 创建一个新的教室 旧教室的椅子全部搬入到新教室中
        elementData = this.copyOf(elementData,newCapacity);//小C同学做完事情之后 得到一个新教室
    }
    //小C同学--->设计一个方法  负责创建一个新数组
    // 将旧数组的元素全部移入新数组内  干体力活的
    //      需要新数组的长度  需要提供旧数组
    //      需要告知新数组的位置---返回新数组
    private Object[] copyOf(Object[] oldArray,int newCapacity){
        //创建一个新的数组(新的小教室)
        Object[] newArray = new Object[newCapacity];
        //将旧数组元素全部移入新数组内
        for(int i=0;i<oldArray.length;i++){
            newArray[i] = oldArray[i];
        }
        //将新数组返回
        return newArray;
    }

    ///====================================================================================

    //需要设计一个方法  用来添加元素
    //      提供什么条件(参数)   返回一个结果(返回值)
    //      需要提供一把椅子int  告知用户一个结果 是否存储成功 boolean
    public boolean add(E element){//创建box对象时 规定的类型
        //确保我自己的属性数组的内部容量
        this.ensureCapacityInternal(size + 1);
        //如果上面的这一行代码可以执行完毕  elementData的教室肯定有空间
        //我想把element存入elementData里  有效元素个数多记录一个
        elementData[size++] = element;
        //告知用户 存储成功
        return true;//表示成功
    }
    //需要设计一个方法  用来获取元素
    //      提供什么条件(参数)      返回结果(返回值)
    //      提供获取元素的位置       获取位置上的那个元素(int--小椅子)
    public E get(int index){
        //检测index范围是否合法
        this.rangeCheck(index);//找到小D同学来帮忙检测
        //如果上面一行代码可以走过去 证明index是合法
        return (E)elementData[index];
    }
    //需要设计一个方法  用来删除元素
    //      提供元素的位置     返回值---删除掉的那个元素
    public E remove(int index){
        //检测index范围
        this.rangeCheck(index);
        //如果这行代码可以执行过去  没有异常  index合法
        //将index位置的旧值保存起来
        E oldValue = (E)elementData[index];
        //10 20 30 40 50 60 0 0 0 0--->有效元素
        //30数字删掉     box.remove(2);
        //10 20 40 50 60 0 0 0 0 0--->size  5个
        for(int i=index;i<size-1;i++){//i==2 3 4
            elementData[i] = elementData[i+1];//从index开始 至size-1为止 将后面位置元素依次前移覆盖
        }//10 20 40 50 60 0 0 0 0 0
        elementData[--size] = null;//末尾元素清空
        //将旧值返回给用户
        return oldValue;
    }
    public int size(){
        return this.size;
    }

}
