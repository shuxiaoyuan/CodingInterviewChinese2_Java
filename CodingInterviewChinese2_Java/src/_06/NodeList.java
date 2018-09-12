package _06;

public class NodeList {

    public Node head;   // 链表头指针 
    
    // 在链表尾部添加一个值为 val 的新节点
    public void addToTail(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    // 删除链表中值为 val 的第一个节点
    public void removeNode(int val) {
        if(head == null) {
            throw new RuntimeException("链表为空，无法删除节点！");
        }
        if(head.val == val) {
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next != null && current.next.val != val) {
            current = current.next;
        }
        if(current.next != null && current.next.val == val) {
            current.next = current.next.next;
        }
        else {
            throw new RuntimeException("链表中没有值为 val 的节点");   
        }
    }
    
    // 顺序打印链表中的节点
    public void show() {
        if(head == null) {
            System.out.println("链表为空！");
            return;
        }
        System.out.print("顺序打印链表：");
        Node current = head;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    
}
