package _09;

import java.util.ArrayDeque;


/**
 * 面试题9：用两个队列实现栈
 * P71
 */

public class StackWithTwoQueues {

    public ArrayDeque<Integer> queue1 = new ArrayDeque<>();
    public ArrayDeque<Integer> queue2 = new ArrayDeque<>();
    
    public static void main(String[] args) {
        StackWithTwoQueues stack = new StackWithTwoQueues();
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(8);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //System.out.println(stack.pop());
    }

    public void push(int val) {
        if(!queue1.isEmpty()) {
            queue1.addLast(val);
        }
        else {
            queue2.addLast(val);
        }
    }
    
    public int pop() {
        if(!queue1.isEmpty()) {
            while(queue1.size() > 1) {
                queue2.addLast(queue1.removeFirst());
            }
            return queue1.removeFirst();
        }
        else if(!queue2.isEmpty()) {
            while(queue2.size() > 1) {
                queue1.addLast(queue2.removeFirst());
            }
            return queue2.removeFirst();
        }
        else {
            throw new RuntimeException("栈已空！");
        }
    }
    
}
