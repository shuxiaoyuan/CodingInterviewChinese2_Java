package _06;

import java.util.ArrayDeque;


/**
 * 面试题6：从尾到头打印链表
 * P58
 */

public class PrintListInReversedOrder {
    
    public static void main(String[] args) {
        NodeList list = new NodeList();
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(5);
        list.addToTail(8);
        list.show();
        printReversingly(list);
    }
    
    // 从尾到头打印链表
    public static void printReversingly(NodeList list) {
        System.out.println("从尾到头打印链表：");
        System.out.print("    （1）辅助栈方式：");
        byStack(list.head);
        System.out.print("    （2）递归的方式：");
        byRecursively(list.head);
        System.out.println();
    }
    
    // 通过辅助栈的方式
    private static void byStack(Node node) {
        ArrayDeque<Node> stack = new ArrayDeque<>();
        while(node != null) {
            stack.push(node);
            node = node.next;
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop().val + " ");
        }
        System.out.println();
    }

    // 通过递归的方式
    private static void byRecursively(Node node) {
        if(node != null) {
            if(node.next != null) {
                byRecursively(node.next);    
            }
            System.out.print(node.val + " ");
        }
    }
    
}
