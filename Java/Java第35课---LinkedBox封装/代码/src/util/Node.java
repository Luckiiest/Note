package util;

public class Node {

    public Node prev;//previous  上一个node对象
    public int item;//当前的数据
    public Node next;//下一个node对象

    public Node(Node prev,int item,Node next){
        this.prev = prev;
        this.item = item;
        this.next = next;
    }
}
