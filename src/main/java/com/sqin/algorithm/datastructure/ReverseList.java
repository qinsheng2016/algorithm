package com.sqin.algorithm.datastructure;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author Sheng Qin
 * @Description
 * @Date 22:09 2021/6/19
 **/
public class ReverseList {

    /**
     * 单向链表
     */
    public static class Node {
        private int value;
        private Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 双向链表
     */
    public static class DoubleNode {
        private int value;
        private DoubleNode pre;
        private DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    /**
     * 反转单向链表
     *
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head) {
        Node next = null;
        Node pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 反转双向链表
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 测试反转单链表
     * 用数组将链表元素全部装进去，然后让每个node的next指向前一个，返回最后一个就是新链表的head。
     *
     * @param head
     * @return
     */
    public static Node testReverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        for (int i = 1; i < list.size(); i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(list.size() - 1);
    }

    /**
     * 随机生成一个长度为len的单向链表
     *
     * @param len
     * @param value
     * @return
     */
    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        Node head = new Node((int) (Math.random() * (value + 1)));
        size--;
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    /**
     * 随机生成一个长度为len的双向链表
     *
     * @param len
     * @param value
     * @return
     */
    public static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        size--;
        head.pre = null;
        head.next = null;
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            cur.pre = pre;
            pre = cur;
            size--;
        }
        return head;
    }

    /**
     * 获得单向链表原始顺序
     *
     * @param head
     * @return
     */
    public static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    /**
     * 获得双向链表原始顺序
     *
     * @param head
     * @return
     */
    public static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    /**
     * 校验单向链表中的数据是否和数组中的顺序完全相反
     *
     * @param origin
     * @param head
     * @return
     */
    public static boolean checkLinkedListReverse(List origin, Node head) {
        head = reverseLinkedList(head);
        for (int i = origin.size() - 1; i > 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 校验双向链表中的数据是否和数组中的顺序完全相反
     *
     * @param origin
     * @param head
     * @return
     */
    public static boolean checkDoubleListReverse(List origin, DoubleNode head) {
        head = reverseDoubleList(head);
        for (int i = origin.size() - 1; i > 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTimes = 100000;
        int i = 0;
        System.out.println("Test start!");
        for (; i < testTimes; i++) {
            Node head = generateRandomLinkedList(len, value);
            List origin = getLinkedListOriginOrder(head);
            if (!checkLinkedListReverse(origin, head)) {
                System.out.println("Linked List Reverse Error!");
            }

            DoubleNode doubleNode = generateRandomDoubleList(len, value);
            List originDoubleNodeArray = getDoubleListOriginOrder(doubleNode);
            if (!checkDoubleListReverse(originDoubleNodeArray, doubleNode)) {
                System.out.println("Double List Reverse Error!");
            }
        }
        System.out.println("Test end!");
    }

}
