package ra;

import java.util.Arrays;
import java.util.Random;

public class Sorting {
    public static void main(String[] args) {
        int[] arr1 = getArr(100000);
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();
        int[] arr4 = arr1.clone();
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println("Sắp xếp nổi bọt");
        long l1 = System.currentTimeMillis();
        bubbleSort(arr1);
        long l2 =System.currentTimeMillis();
        System.out.println("Thời gian thực thi nổi pọt = "+(l2-l1));
        System.out.println("Sắp xếp chọn");
        long l3 = System.currentTimeMillis();
        selectionSort(arr2);
        long l4 =System.currentTimeMillis();
        System.out.println("Thời gian thực thi chọn = "+(l4-l3));
        System.out.println("Sắp xếp chèn");
        long l5 = System.currentTimeMillis();
        insertionSort(arr3);
        long l6 =System.currentTimeMillis();
        System.out.println("Thời gian thực thi chèn = "+(l6-l5));
        System.out.println("Sắp xếp quicksort");
        long l7 = System.currentTimeMillis();
        Arrays.sort(arr4);
        long l8 =System.currentTimeMillis();
        System.out.println("Thời gian thực thi quick = "+(l8-l7));


    }
    public  static int[] getArr (int count){
        int[] arr = new int[count];
        Random random  = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(count*10);
        }
        return arr;
    }
    public static void bubbleSort(int[] arr){
        boolean needNextPass = true;
        for (int i = 1; i < arr.length && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < arr.length-i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int currentMinValue = arr[i];
            int indexMinValue = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<currentMinValue){
                    currentMinValue = arr[j];
                    indexMinValue = j;
                }
            }
            if (indexMinValue!=i){
                arr[indexMinValue] = arr[i];
                arr[i] = currentMinValue;
            }
        }
    }
    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length ; i++) {
            int currentElement = array[i];
            int k;
            for (k = i-1; k >=0 && array[k]> currentElement ; k--) {
                array[k+1] = array[k];
            }
            array[k+1] = currentElement;
        }
    }
}
