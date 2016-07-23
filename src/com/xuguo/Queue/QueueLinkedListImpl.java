package com.xuguo.Queue;

import java.util.NoSuchElementException;

/**
 * Created by xu on 2016/7/20.
 */
public class QueueLinkedListImpl {
    private ListNode head;
    private ListNode tail;

    public void enqueue(int val) {
        if (isEmpty()) {
            head = tail = new ListNode(val);
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
    }

    public int dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int ret = head.val;
        head = head.next;
        return ret;
    }

    public int peek() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void empty() {
        head = null;
    }

    public void print(){
        while(head != null){
            System.out.print(head.val);
            head = head.next;
        }
    }


}
