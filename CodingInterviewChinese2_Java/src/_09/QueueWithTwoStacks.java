package _09;

import java.util.ArrayDeque;


/**
 * 面试题9：用两个栈实现队列
 * P68
 */

public class QueueWithTwoStacks {

    public ArrayDeque<Integer> stack1 = new ArrayDeque<>();   // 入队的栈
    public ArrayDeque<Integer> stack2 = new ArrayDeque<>();   // 出队的栈
    
    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();

        //queue.deleteHead();

        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(5);
        queue.appendTail(8);
        
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());

    }

    public void appendTail(int val) {
        stack1.push(val);
    }
    
    public int deleteHead() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return stack2.pop();
    }
    
}
