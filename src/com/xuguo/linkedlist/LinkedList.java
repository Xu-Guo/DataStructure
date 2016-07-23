package com.xuguo.linkedlist;

/**
 * Created by xu on 2016/7/16.
 */
public class LinkedList {

    private ListNode head;

    public int getLength() {
        if (head == null) return 0;
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    //获取任意位置上的节点的value
    public int get(int location) {
        int length = this.getLength();
        if (location < 0 || location > length) {
            throw new IndexOutOfBoundsException();
        } else {
            ListNode p = head;
            while (location > 0) {
                location--;
                p = p.next;
            }
            return p.val;
        }
    }

    //在任意位置插入元素
    public void add(int location, int val) {

        int length = this.getLength();
        if (location < 0 || location > length) {
            throw new IndexOutOfBoundsException();
        }
        //如果头为null
        if (head == null) {
            head = new ListNode(val);
        } else if (location == 0) { //在头部插入一个新node
            ListNode newHead = new ListNode(val);
            newHead.next = head;
            head = newHead;
        } else {
            //step 1: 找到插入位置前1个节点
            ListNode p = head;
            int t = location - 1;
            while (t > 0) {
                p = p.next;
                t--;
            }
            //step 2: 保存插入位置节点的引用
            ListNode next = p.next;
            //step 3: 断开插入位置节点的引用，并将前一个节点的next指向新插入节点
            ListNode newNode = new ListNode(val);
            p.next = newNode;
            //step 4:新节点的next指向之前插入位置节点
            newNode.next = next;
        }
    }

    //删除指定位置的节点
    public ListNode remove(int location) {
        if (head == null) return head;

        int length = this.getLength();
        if (location < 0 || location > length) {
            throw new IndexOutOfBoundsException();
        }
        if (location == 0) {
            head = head.next;
            return head;
        } else {

            ListNode p = head;
            int i = location - 1;
            while (i > 0) {
                i--;
                p = p.next;
            }

            if (p.next != null) {
                p.next = p.next.next;
            } else {
                return head;
            }
            return head;
        }
    }

    //查找是否包含一个元素
    public boolean contains(int val) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void print() {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
