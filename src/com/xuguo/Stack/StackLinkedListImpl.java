package com.xuguo.Stack;

import java.util.NoSuchElementException;

/**
 * Created by xu on 2016/7/18.
 */
public class StackLinkedListImpl {

    private ListNode head;


    public void push(int val){
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        head = newHead;
    }

    public int pop(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int ret = head.val;
        head = head.next;
        return ret;
    }

    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return head.val;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void empty() {
        head = null;
    }

    public void print(){
        ListNode p = head;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}
