package com.su.springbootinterceptortest.utils.linklist;

import java.util.Objects;

/**
 * 这是一个反例，最开始写时没注意到
 * 参数传递 ：
 *  1、值传递- 基础类型是值传递，不改变原始值
 *  2、引用传递：传递地址，原始值改变
 *  3、string 值不变
 */
public class LinkListErr {


    public static void main(String args[]) {

        Node head = null;

        LinkListErr linkList = new LinkListErr();
        linkList.addToTail(head, 1);
        linkList.addToTail(head, 2);
        linkList.addToTail(head, 3);

        linkList.print(head);

        linkList.remove(head,2);

        linkList.print(head);

    }

    void print(Node head) {
        Node p = head;
        while(p != null) {
            System.out.println(p.value);
            p = p.next;
        }
    }

    void addToTail(Node head, int value) {

        Node node = new Node(value); // 此处是引用传递，但是因为new了一个新的对象，head已经不是原来的地址

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


    boolean remove(Node head, int r) {
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
