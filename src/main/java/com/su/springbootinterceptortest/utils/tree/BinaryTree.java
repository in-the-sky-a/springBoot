package com.su.springbootinterceptortest.utils.tree;

import com.su.springbootinterceptortest.utils.linklist.LinkList;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {

    private int[] intValue = {1,2,3,4,5,6,7,8,9};

    public static void main(String args[]) {
        BinaryTree binaryTree = new BinaryTree();
        List<Node> binaryTreeInit = binaryTree.createBinaryTree();
        binaryTree.preOrderTraverse(binaryTreeInit.get(0));
        System.out.println("\n");
        binaryTree.inOrderTraverse(binaryTreeInit.get(0));
        System.out.println("\n");
        binaryTree.postOrderTraverse(binaryTreeInit.get(0));

    }


    //构建二叉树
    private List<Node> createBinaryTree() {
        //将数组转成节点
        List<Node> linkList = new LinkedList();
        for(int a: intValue) {
            Node node = new Node(a);
            linkList.add(node);
        }

        for(int parentIndex = 0; parentIndex < linkList.size() / 2 - 1; parentIndex ++) {
            int leftIndex = parentIndex * 2 + 1;
            int rightIndex = parentIndex * 2 + 2;
            linkList.get(parentIndex).left = linkList.get(leftIndex);
            linkList.get(parentIndex).right = linkList.get(rightIndex);

        }

        int lastParentIndex = linkList.size() / 2 - 1;
        linkList.get(lastParentIndex).left = linkList.get(lastParentIndex * 2 + 1);
        if(linkList.size() % 2 == 1)
            linkList.get(lastParentIndex).right = linkList.get(lastParentIndex * 2 + 2);

        return linkList;

    }

    //先序遍历
    private void preOrderTraverse(Node node) {
        if(node == null)
            return;
        System.out.print(node.value);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }


    //中序遍历
    private void inOrderTraverse(Node node) {
        if(node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.value);
        inOrderTraverse(node.right);
    }

    //后序遍历
    private void postOrderTraverse(Node node) {
        if(node == null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.value);
    }


    class Node{
        private int value;
        private Node left;
        private Node right;
        Node(int value) {
            this.value = value;
        }
    }


}
