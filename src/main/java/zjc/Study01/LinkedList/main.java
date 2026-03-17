package zjc.Study01.LinkedList;

public class main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.insertAtHead(4);
        list.insertAtHead(5);
        list.insertAtHead(6);
        list.insertAtHead(7);
        list.insertAtHead(8);
        list.insertAtHead(9);
        list.insertAtHead(10);
        list.insertAtHead(11);
        list.insertAtHead(12);
        list.insertAtHead(13);
        list.insertAtHead(14);
        list.insertAtHead(15);
        list.display();


        /// 插入数据到倒数第k个位置
        list.insertIntoTail(10,99);
        list.display();

        /// 判断是否为循环链表
//        System.out.println(list.isrecycLinkedList());

//        list.makeCycle();
//        System.out.println(list.isrecycLinkedList());


        /// 倒序输出链表
        list.display();
        list.reverseLinkedList();
        list.display();
    }
}
