package com.su.springbootinterceptortest.utils.tree;

import java.util.Stack;

/**
 * 剑指offer面试题9
 * 两个栈模拟一个队列实现
 *
 */
public class QueueImplBy2Stacks {

    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> stack2 = new Stack();


    public static void main(String args[]) {
        QueueImplBy2Stacks queueImplBy2Stacks = new QueueImplBy2Stacks();
        queueImplBy2Stacks.enqueue(1);
        queueImplBy2Stacks.enqueue(2);
        queueImplBy2Stacks.enqueue(3);

        System.out.println(queueImplBy2Stacks.dequeue());
        System.out.println(queueImplBy2Stacks.dequeue());
        System.out.println(queueImplBy2Stacks.dequeue());

        queueImplBy2Stacks.enqueue(4);
        queueImplBy2Stacks.enqueue(5);
        System.out.println(queueImplBy2Stacks.dequeue());
        queueImplBy2Stacks.enqueue(6);
        System.out.println(queueImplBy2Stacks.dequeue());



    }

    private void enqueue(int element) {
        stack1.push(element);
    }

    private int dequeue() {

        if(stack2.empty()) {
            while(!stack1.empty()) {
                Integer pop = stack1.pop();
                stack2.push(pop);

            }
        }

        if(!stack2.empty()) {
            return (int)stack2.pop();
        }

        return -1;
    }
}
