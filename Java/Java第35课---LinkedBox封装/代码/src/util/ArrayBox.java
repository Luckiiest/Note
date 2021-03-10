package util;

public class ArrayBox implements Box{

    //设计一个静态常量 用来存储数组的默认长度
    private static final int DEFAULT_CAPACITY = 10;
    //设计一个自己的属性  用来存放真实数据的  []
    private int[] elementDate;
    //设计一个自己的属性  用来记录数组内存储的有效元素个数
    private int size = 0;

    //构造方法重载
    public ArrayBox(){
        elementDate = new int[DEFAULT_CAPACITY];
    }
    public ArrayBox(int capacity){
        elementDate = new int[capacity];
    }


    //小A同学 负责确保数组内部的容量
    private void ensureCapacityInternal(int minCapacity){
        //判断如果你需要的最小容量比原数组的长度还要大
        if(minCapacity - elementDate.length > 0){
            //需要进行数组的扩容 找别人计算扩容的大小
            this.grow(minCapacity);
        }
    }
    //小B同学 负责计算扩容大小
    private void grow(int minCapacity){
        //获取原数组的长度
        int oldCapacity = elementDate.length;
        //小B同学帮我做了一个计算  在原数组之上增加1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        //比较计算后的长度与所需的长度
        if(newCapacity - minCapacity < 0){
            //那么直接按照所需的长度作为新数组的长度
            newCapacity = minCapacity;
        }
        //调用小C同学 让他创建新数组  将原数组中的所有元素移入新数组中
        elementDate = this.copyOf(elementDate,newCapacity);
    }
    //小C同学 负责将原数组中的元素移入新数组中
    private int[] copyOf(int[] oldArray,int newCapacity){
        //按照提供的长度创建一个新数组
        int[] newArray = new int[newCapacity];
        //将原数组中的元素按照位置移入新数组中
        for(int i=0;i<oldArray.length;i++){
            newArray[i] = oldArray[i];
        }
        //将新数组返回
        return newArray;
    }
    //小D同学 检测给定index是否合法
    private void rangeCheck(int index){
        if(index<0 || index>=size){
            //自定义一个异常 来说明问题
            throw new BoxIndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
    }

    //------------------------------------------------------------
    //用来将用户给定的element存起来  参数是需要存起来的元素  返回值是否存储成功
    public boolean add(int element){
        //找一个别人 做事 确保数组的内部容量够用
        this.ensureCapacityInternal(size+1);
        //上述一行代码可以执行完毕 证明elementDate的数组肯定够用
        //直接将新来的element元素存入数组中 并且让size多记录一个
        elementDate[size++] = element;
        //返回true告知用户存储元素成功
        return true;
    }
    //用来获取给定位置的元素  参数是索引位置  返回值是取得的元素
    public int get(int index){
        //找一个小弟 检测给定的index是否合法
        this.rangeCheck(index);
        //上述代码可以执行  证明index是合法的
        //则找到index对应位置的元素 将其返回
        return elementDate[index];
    }
    //用来删除给定位置的元素  参数是索引位置  返回值是删除掉的那个元素
    public int remove(int index){
        //调用小D同学 检测index
        this.rangeCheck(index);
        //上述代码可以执行 index是合法的
        //找到index位置的元素 保留起来 留给用户
        int oldValue = elementDate[index];
        //1 2 3 4 5 6   size==6个
        //1 2 4 5 6 0   elementDate[5]=0   size-1
        //从index位置开始至size-1结束 后面元素依次前移覆盖
        for(int i=index;i<size-1;i++){
            elementDate[i] = elementDate[i+1];
        }
        //手动将最后的元素删除  让size减少一个记录
        elementDate[--size] = 0;
        //将旧数据返回
        return oldValue;
    }
    //设计一个方法 用来获取size有效的个数  没有设置 可以保护size的安全
    public int size(){
        return size;
    }

}
