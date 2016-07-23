package com.xuguo.Stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by xu on 2016/7/18.
 */
public class StackArrayListImpl {

    private ArrayList<Integer> data;

    public StackArrayListImpl(){
        data = new ArrayList<Integer>();
    }

    public void push(int val){
        data.add(val);
    }

    public int pop(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return data.remove(data.size() - 1);
    }

    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return data.get(data.size() - 1);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void empty(){
        data.clear();
    }

    public void print(){
        System.out.println(data);
    }


}
