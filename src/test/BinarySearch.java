package test;

public class BinarySearch {
    public static int binarySearch(int[] array, int left, int right, int target){
        if(left>right) return -1;
        int mid = (left+right)/2;
        if(array[mid]==target) return mid;
        else if (array[mid]<target) return binarySearch(array, mid+1, right, target);
        else return binarySearch(array,left, mid-1, target);
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,3,4,5}, 0, 4, 2));
    }
}

