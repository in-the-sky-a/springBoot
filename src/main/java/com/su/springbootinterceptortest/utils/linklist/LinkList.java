package com.su.springbootinterceptortest.utils.linklist;

import java.util.Objects;
import java.util.Stack;

public class LinkList {

    private Node head;


    public static void main(String args[]) {

        LinkList linkList = new LinkList();
        linkList.addToTail(1);
        linkList.addToTail(2);
        linkList.addToTail(3);

        /*linkList.print();
        linkList.remove(2);
        linkList.print();
*/
        /*//栈实现逆序打印
        linkList.printReverse();*/

        //递归实现逆序打印
        linkList.printRecursionCall();
    }

    void print() {
        Node p = head;
        while(p != null) {
            System.out.println(p.value);
            p = p.next;
        }
    }

    //用栈实现逆序打印
    void printReverse() {
        Stack stack = new Stack();
        Node p = head;
        while(p != null) {
            stack.push(p.value);
            p = p.next;
        }

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    //递归实现逆序打印
    void printRecursionCall() {
        LinkList linkList = new LinkList();
        linkList.printRecursion(head);
    }
    void printRecursion(Node p) {

        /*if(p != null) {

            if(p.next != null) {
                printRecursion(p.next);

            }
            System.out.println(p.value);

        }*/

        // 这是一个反例，打印p的时候p已经变成了 p.next
        /*if(p == null) {
            return;
        } else  {
            p = p.next;
            if(p != null)
                printRecursion(p);

        }*/


        if(p == null) {
            return;
        } else  {
            if(p.next != null)
                printRecursion(p.next);

        }

        System.out.println(p.value);

    }

    void addToTail(int value) {

        Node node = new Node(value);
        if(head == null)
            head = node;
        else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
    }


    boolean remove(int r) {
        if(head == null )
            return false;
        if(Objects.equals(head.value, r)) {
            head = head.next;
            return true;
        }
        Node p = head;
        while(p != null && !Objects.equals(p.next.value, r)) {
            p = p.next;
        }

        if(p == null)
            return false;

        Node q = p.next;
        p.next = q.next;
        return true;
    }


    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }


}
