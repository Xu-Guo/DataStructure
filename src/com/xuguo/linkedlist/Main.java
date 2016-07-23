package com.xuguo.linkedlist;

/**
 * Created by xu on 2016/7/18.
 */
public class Main {
    public static void main(String [] argus){
        LinkedList list = new LinkedList();

        list.add(0,1);
        list.add(0,2);
        list.add(0,3);
        list.add(0,4);
        list.add(0,5);

        //list.print();

        list.add(1,10);
        list.add(1,20);

        //System.out.println(list.contains(10));
        //System.out.println(list.contains(11));
        list.print();

        list.remove(0);
        list.remove(0);

        list.print();

    }
}
