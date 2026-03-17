package zjc.Study01.LinkedList;

/**
 * 链表部分
 */
public class LinkedList {
    // 头结点
    private Node head;

    /// 构建函数，创建一个空链表
    public LinkedList() {
        this.head = null;
    }

    /// 判断链表是否为空
    public boolean isEmpty(){
        return head == null;
    }

    /// 头插法
    public void insertAtHead(int data){
        if(isEmpty()){
            head = new Node(data);
        }
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next = newNode;
    }

    /// 尾插法
    public void insertAtTail(int data){
        if(isEmpty()){
            head = new Node(data);
        }
        Node newNode = new Node(data);
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }
    /// 在指定位置插入节点
    public void insertAtIndex(int index, int data,LinkedList dataNode){
        if(isEmpty()){
            head = new Node(data);
        }
        if(index <=0){
            insertAtHead(data);
        }
        int dataNodecount = dataNode.LinkedListSize();
        if(index >= dataNodecount){
            System.out.println("超过链表长度");
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    /// 删除第一个值为data的节点
    public void deleteAtIndex(int data){
        if(isEmpty()){
            return;
        }
        Node pref = head;
        Node current = pref.next;
        while(current.data != data){
            pref = pref.next;
            current = pref.next;
        }
        pref.next = current.next;

    }
    /// 查找节点
    public void selectAtIndex(int data){
        if(isEmpty()){
            return;
        }
        Node current = head;
        while(current.data != data){
            current = current.next;
        }
        System.out.println(current.data);
    }
    /// 打印链表
    public void display(){
        if(isEmpty()){
            return;
        }
        Node current = this.head;
        while(current != null){
            System.out.print(current.data+"-> ");
            current = current.next;
        }
        System.out.println();
    }
    /// 获取链表长度
    public int LinkedListSize(){
        int count = 0;
        if(isEmpty()){
            showCount(count);
            return 0;
        }
        Node current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        showCount(count);
        return count;
    }
    public void showCount(int count){
        System.out.println("链表长度为："+count);
    }
    /// 查找到倒数第k个位置插入数据
    public void insertIntoTail(int tailIndex,int data){
        if(isEmpty()){
            return;
        }
        int k = tailIndex-1;
        Node newNode = new Node(data);
        Node current = head;
        Node prev = null;
        if(k == 0){
            insertAtHead(data);
            return;
        }
        if(k>LinkedListSize()){
            System.out.println("超过最大值");
            return;
        }
        current = head;
        prev = head;
        for(int i = 0; i < k; i++){
            current = current.next;
        }
        while(current.next != null){
            current = current.next;
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }
    /// 判断链表是否循环
    public boolean isrecycLinkedList(){
        Node fast = head;
        Node slow = head;
        if(head == null){
            return false;
        }
        while(fast.next != null){
            if(fast.next == slow){
                return true;
            }
            fast=fast.next.next;//走两步
            slow=slow.next;//走一步
        }
        return false;
    }
    /// 制作循环链表
    public void makeCycle(){
        Node current = head;
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = head;
    }

    /// 链表反向排序
    public void reverseLinkedList(){
        Node current = head.next;
        Node fast = null;
        if(head == null){
            return;
        }
        while(current.next != null){
            fast = current.next;
            current.next=fast.next;
            fast.next = head.next;
            head.next=fast;
        }
    }
}
