package com.xuguo.Algorithm;

import java.util.Stack;

/**
 * Created by xuxu on 10/30/16.
 */
public class StackWithGetMin {

    public class myStack {
        /*
        design a special stack data structure and implement getMin function.
        use two stacks: stack 1: normal stack stores data
                        stack 2: stores minValue for each step
         */
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public myStack(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum){
            if(this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if(newNum <= this.getMin()){
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop(){
            if(this.stackData.isEmpty()){
                throw new RuntimeException("Stack is empty!");
            }

            int value = this.stackData.pop();
            if(value == this.getMin()){
                this.stackMin.pop();
            }
            return value;
        }

        public int getMin(){
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("Stack is empty!");
            }
            return this.stackMin.peek();
        }
    }
}
