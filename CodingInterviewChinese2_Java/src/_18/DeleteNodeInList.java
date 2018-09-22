package _18;

/**
 * 面试题18：删除链表的节点
 * P119
 */
public class DeleteNodeInList {

    public static Node head;    // 链表头结点
    
    static class Node {
        int val;
        Node next = null;
        
        public Node(int val) {
            this.val = val;
        } 
    }
    
    public static void main(String[] args) {
         head = new Node(1);
         head.next = new Node(2);
         head.next.next = new Node(3);
         deleteNode(head);
         show();
    }
    
    public static void deleteNode(Node node) {
        if(node == null) {
            return;
        }
        // 链表有多个节点，且要删除的节点不是尾节点
        if(node.next != null) {
            Node next = node.next;
            node.val = next.val;
            node.next = next.next;
        }
        // 链表只有一个节点，且要删除的为头结点
        else if(node == head) {
            head = null;
        }
        // 要删除的为尾节点
        else {
            Node tmp = head;
            while(tmp.next != node) {
                tmp = tmp.next;
            }
            tmp.next = null;
        }
    }
    
    public static void show() {
        Node node = head;
        while(node != null) {
            System.out.println(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}
