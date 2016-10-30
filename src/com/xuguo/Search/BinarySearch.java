package com.xuguo.Search;

/**
 * Created by xuxu on 10/26/16.
 */
public class BinarySearch {

    public static int binarySearch(int target, int [] data){
        if(data == null || data.length == 0){
            return -1;
        }

        int low = 0;
        int high = data.length - 1;
        while(high >= low){
            int middle = low + (high - low) / 2;
            if(data[middle] == target){
                return middle;
            }else if(data[middle] > target){
                high = middle - 1;
            }else{
                low = middle + 1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,7,8,9,10};
        int target = 3;
        System.out.println(binarySearch(target,a));
    }
}
