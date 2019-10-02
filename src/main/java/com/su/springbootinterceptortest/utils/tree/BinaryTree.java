package com.su.springbootinterceptortest.utils.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

   // private int[] intValue = {1, 2, 3, 4, 5, 6, 7, 8, 9};
   private int[] intValue = {10, 6, 14, 4, 8, 12, 16};

    public static void main(String args[]) {
        BinaryTree binaryTree = new BinaryTree();
        List<Node> binaryTreeInit = binaryTree.createBinaryTree();
      /*  binaryTree.preOrderTraverse(binaryTreeInit.get(0));
        System.out.println("\n");*/
        binaryTree.printAccordingLine(binaryTreeInit.get(0));
        /*binaryTree.inOrderTraverse(binaryTreeInit.get(0));
        System.out.println("\n");
        binaryTree.postOrderTraverse(binaryTreeInit.get(0));

        int[] pre = {1,2,4,8,9,5,3,6,7};
        int[] in = {8,4,9,2,5,1,6,3,7};
        Node bTreeFromPreAndIn = binaryTree.createBTreeFromPreAndIn(pre, in);
        binaryTree.preOrderTraverse(bTreeFromPreAndIn);*/

        binaryTree.convertList(binaryTreeInit.get(0));

    }


    //构建二叉树
    private List<Node> createBinaryTree() {
        //将数组转成节点
        List<Node> linkList = new LinkedList();
        for (int a : intValue) {
            Node node = new Node(a);
            linkList.add(node);
        }

        for (int parentIndex = 0; parentIndex < linkList.size() / 2 - 1; parentIndex++) {
            int leftIndex = parentIndex * 2 + 1;
            int rightIndex = parentIndex * 2 + 2;
            linkList.get(parentIndex).left = linkList.get(leftIndex);
            linkList.get(parentIndex).right = linkList.get(rightIndex);

        }

        int lastParentIndex = linkList.size() / 2 - 1;
        linkList.get(lastParentIndex).left = linkList.get(lastParentIndex * 2 + 1);
        if (linkList.size() % 2 == 1)
            linkList.get(lastParentIndex).right = linkList.get(lastParentIndex * 2 + 2);

        return linkList;

    }

    //根据前序和中序遍历构建二叉树
    private Node createBTreeFromPreAndIn(int[] pre, int in[]) {

        if(pre == null || in == null)
            return null;
        Node  root = createBTreeFromPreAndInCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private Node createBTreeFromPreAndInCore(int[] pre, int startPre, int endPre , int[] in, int startIn, int endIn) {
        Node root = new Node(pre[startPre]);
        root.left = null;
        root.right = null;

        if(startPre == endPre && startIn == endIn)
            return root;

        int i = startIn;
        for(; i < endIn; i++) {
            if(in[i] == pre[startPre])
                break;
        }

        int leftLength = i - startIn;
        int rightLength = endIn - i;

        if(leftLength > 0) {
            root.left = createBTreeFromPreAndInCore(pre, startPre + 1, startPre + leftLength, in, startIn, startIn + leftLength - 1);
        }

        if(rightLength > 0) {
            root.right = createBTreeFromPreAndInCore(pre, startPre + leftLength + 1, endPre, in, startIn + leftLength + 1, endIn);
        }

        return root;
    }

    //先序遍历
    private void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.value);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }


    //中序遍历
    private void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.value);
        inOrderTraverse(node.right);
    }

    //后序遍历
    private void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.value);
    }


    class Node {
        private int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
        }
    }


    /**
     * 按行打印二叉树
     * 剑指offer面试题32
     * @param node
     */

    private void printAccordingLine(Node node) {

        if(node == null)
            return;

        List<Node> list = new LinkedList<>();
        list.add(node);

        while(list.size() > 0) {
            Node fNode = list.remove(0);
            System.out.print(fNode.value + " ");

            if(fNode.left != null)
                list.add(fNode.left);
            if(fNode.right != null)
                list.add(fNode.right);


        }
    }


    /**
     * 二叉搜索树转成双向链表,并打印
     */

    private void convertList(Node node) {
        if(node == null)
            return;

        Node lastNode = null;
        lastNode = convert(node, lastNode);

        Node head = lastNode;
        while(head.left != null) {
            head = head.left;
        }

        System.out.println();
        while (head != null) {
            System.out.print(head.value);
            head = head.right;
        }

    }

    private static Node convert(Node node, Node lastNode) {

        if(node == null)
            return null;

        Node current = node;
        if(current.left != null) {
            lastNode = convert(current.left, lastNode);
        }

        current.left = lastNode;
        if(lastNode != null)
            lastNode.right = current;

        lastNode = current;
        if(current.right != null) {
            lastNode = convert(current.right, lastNode);
        }


        return lastNode;
    }


}
