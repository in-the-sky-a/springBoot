package com.su.springbootinterceptortest.utils.tree;


import java.util.LinkedList;
import java.util.List;

/**
 * 剑指offer 面试题8
 * 中序遍历找下一个节点
 */
public class BTFindNextNode {

    private int[] intValue = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String args[]) {
        BTFindNextNode btFindNextNode = new BTFindNextNode();
        List<Node> binaryTree = btFindNextNode.createBinaryTree();
        Node node = binaryTree.get(6);
        Node nextNode = btFindNextNode.getNextNode(node);
        System.out.println("node: " +  node.value + ",next node :" + (nextNode == null ? "null": nextNode.value));
    }

    //构建二叉树
    private List<BTFindNextNode.Node> createBinaryTree() {
        //将数组转成节点
        List<BTFindNextNode.Node> linkList = new LinkedList();
        for (int a : intValue) {
            BTFindNextNode.Node node = new BTFindNextNode.Node(a);
            linkList.add(node);
        }

        for (int parentIndex = 0; parentIndex < linkList.size() / 2 - 1; parentIndex++) {
            int leftIndex = parentIndex * 2 + 1;
            int rightIndex = parentIndex * 2 + 2;
            linkList.get(parentIndex).left = linkList.get(leftIndex);
            linkList.get(parentIndex).right = linkList.get(rightIndex);
            linkList.get(leftIndex).parent = linkList.get(parentIndex);
            linkList.get(rightIndex).parent = linkList.get(parentIndex);

        }

        int lastParentIndex = linkList.size() / 2 - 1;
        linkList.get(lastParentIndex).left = linkList.get(lastParentIndex * 2 + 1);
        linkList.get(lastParentIndex * 2 + 1).parent = linkList.get(lastParentIndex);

        if (linkList.size() % 2 == 1) {
            linkList.get(lastParentIndex).right = linkList.get(lastParentIndex * 2 + 2);
            linkList.get(lastParentIndex * 2 + 2).parent = linkList.get(lastParentIndex);
        }

        return linkList;

    }

    private Node getNextNode(Node node) {
        if(node == null)
            return null;
        Node nextNode;

        if(node.right != null) {
            Node right = node.right;
            while (right.left != null) {
                right = right.left;
            }
            nextNode = right;

        } else {

            while(node.parent != null && node.parent.right == node) {
                node = node.parent;
            }

            nextNode = node.parent;

        }

        return nextNode;
    }

    class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        Node(int v) {
            this.value = v;
        }
    }
}
