package com.xuguo.Algorithm;

import java.util.Stack;

/**
 * Created by xuxu on 10/30/16.
 */
public class TwoStackQueue {
    /*
    implement a queue with two stacks
    stack 1: stackPush only for push data
    stack 2: stackPop only for pop data
     */

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueue(){
        this.stackPop = new Stack<Integer>();
        this.stackPush = new Stack<Integer>();
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
    }

    public int poll(){
        if(stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }else if(stackPop.isEmpty()){ //here stackPop must be empty before we can push any data into it
            while(!stackPush.isEmpty()){//here we must push all the data in stackPush into stackPop
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty!");
        }else if(stackPop.empty()){ //here stackPop must be empty before we can push any data into it
            while(!stackPush.empty()){//here we must push all the data in stackPush into stackPop
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
