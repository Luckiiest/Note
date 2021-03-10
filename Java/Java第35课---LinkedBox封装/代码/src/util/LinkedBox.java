package util;

public class LinkedBox implements Box{

    //创建几个属性
    private Node first;//记录首节点
    private Node last;//记录尾节点
    private int size;//记录有效元素的个数
    
    //设计一个小A同学  负责将元素添加在新的node里 挂在链表的尾端
    private void linkLast(int element){
        //获取链表的尾节点
        Node l = last;
        //创建一个新的node对象 将新数据包装起来
        Node newNode = new Node(l,element,null);
        //将新节点对象设置为尾节点
        last = newNode;
        //严谨的判断
        if(l==null){//如果原来尾节点没有对象 证明这个链表没有使用过的
            first = newNode;
        }else{//原来用过 刚才已经将新的节点连接在last之后啦
            l.next = newNode;
        }
        //有效元素个数增加一个
        size++;
    }
    //设计一个小B同学 负责检测index
    private void rangeCheck(int index){
        if(index<0 || index>=size){
            throw new BoxIndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
    }
    //设计一个小C同学 负责找寻给定index位置的node对象
    private Node node(int index){
        Node targetNode;//用来存储找到的当前那个目标
        //判断index范围是在前半部分 还是在后半部分
        if(index < (size>>1)){//从前往后找寻比较快
            targetNode = first;
            for(int i=0;i<index;i++){
                targetNode = targetNode.next;
            }
        }else{//从后往前找
            targetNode = last;
            for(int i=size-1;i>index;i--){
                targetNode = targetNode.prev;
            }
        }
        return targetNode;
    }
    //设计一个方法 小D同学  负责将给定的node节点对象删除  并且保留数据
    private int unlink(Node targetNode){
        //获取当前node的item信息---
        int oldValue = targetNode.item;
        //当前node的前一个
        Node prev = targetNode.prev;
        //当前node的下一个
        Node next = targetNode.next;
        //删除节点对象
        if(prev==null){//当前node就是第一个
            first = next;
        }else{
            prev.next = next;
            targetNode.prev = null;
        }
        if(next==null){//当前node就是最后一个
            last = prev;
        }else{
            next.prev = prev;
            targetNode.next = null;
        }
        //让有效元素减少一个
        size--;
        return oldValue;
    }
    //-------------------------------------------------------
    //数据结构
    public boolean add(int element) {
        //将element存入一个新的Node对象里 添加至链表的尾端
        this.linkLast(element);
        //告知添加成功
        return true;
    }
    public int get(int index) {
        //检测index是否合法
        this.rangeCheck(index);
        //找寻index对应位置的那个node对象  将对象中的数据取出来
        Node targetNode = this.node(index);
        //返回找到的node对象内数据
        return targetNode.item;
    }
    public int remove(int index) {
        //检测范围是否合法
        this.rangeCheck(index);
        //找到index位置的那个node
        Node targetNode = this.node(index);
        //设计一个小D同学  负责删除当前的目标节点  让他帮我们返回oldValue
        int oldValue = this.unlink(targetNode);
        return oldValue;
    }
    public int size() {
        return size;
    }
}
