package _18;

/**
 * 面试题18：删除链表中重复的节点
 * P122
 */
public class DeleteDuplicatedNode {

    public static Node head;
    
    public static class Node {
        int val;
        Node next;
        
        Node(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        // int[] vals = {1, 2, 3, 3, 4, 4, 5};
        // int[] vals = {1, 1, 2, 2, 3, 3, 4, 4, 5};
        // int[] vals = {1, 2, 3, 3, 4, 4, 5, 5};
        // int[] vals = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        // int[] vals = {1, 2, 3, 4, 5};
        // int[] vals = {};
        int[] vals = null;
        
        insertNodes(vals);
        show();
        deleteDuplicate();
        show();
    }
    
    public static void deleteDuplicate() {
        if(head == null) {
            return;
        }
        Node pre = null;
        Node current = head;
        while(current != null) {
            Node next = current.next;
            if(next == null || next.val != current.val) {
                pre = current;
            }
            else {
                while(next != null && next.val == current.val) {
                    next = next.next;
                }
                if(pre == null) {
                    head = next;
                }
                else {
                    pre.next = next;
                }
            }
            current = next;
        }
    }

    public static void insertNodes(int[] vals) {
        if(vals == null || vals.length == 0) {
            return;
        }
        head = new Node(vals[0]);
        Node current = head;
        for(int i = 1; i < vals.length; i++) {
            current.next = new Node(vals[i]);
            current = current.next;
        }
    }
    
    public static void show() {
        Node current = head;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    
}
