package programers.레벨1;

import java.util.*;

public class K번째수 {
    public static void main(String[] args) {
        for(int num: mergeSort(new int[]{1, 5, 2, 6, 3, 7, 4})){
            System.out.println(num);
        }
    }
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] command : commands) {
            int num = SortAndGetNum(array, command);
            answer[idx++] = num;
        }
        return answer;
    }
    public int SortAndGetNum(int[] array, int[] command) {
        int[] subArray = Arrays.copyOfRange(array, command[0]-1, command[1]);
//        Arrays.sort(subArray);
//        selectSort(subArray);
//        insertSort(subArray);
//        bubbleSort(subArray);
        subArray = mergeSort(subArray);
        return subArray[command[2]-1];
    }
    public int[] selectSort(int[] array){
        for(int i = 0; i < array.length; i++) {
            int min = array[i];
            int min_idx = i;
            for(int j = i+1; j < array.length; j++) {
                if(min > array[j]){
                    min = array[j];
                    min_idx = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[min_idx] = temp;
        }
        return array;
    }
    public int[] insertSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int num = array[i];
            for(int j = i-1; j >= 0; j--){
                int temp = array[j];
                if(num < array[j]){
                    array[j] = num;
                    array[j+1] = temp;
                }else{
                    break;
                }
            }
        }
        return array;
    }
    public static int[] bubbleSort(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - 1; j++){
                int num1 = array[j];
                int num2 = array[j+1];
                if(num1 > num2){
                    array[j] = num2;
                    array[j+1] = num1;
                }
            }
        }
        return array;
    }
    public static int[] mergeSort(int[] array) {
        partition(array, 0, array.length);
        return array;
    }
    static void merge(int[] array, int left, int right) {
        int[] copyArray = new int[array.length];
        for(int i = 0; i < right; i++) {
            copyArray[i] = array[i];
        }
        int mid = (left + right) / 2;
        int tLeft = left;
        int tRight = mid + 1;
        int curIdx = left;

        while(tLeft <= mid && tRight <= right) {
            if(copyArray[tLeft] <= copyArray[tRight]){
                array[curIdx++] = copyArray[tLeft++];
            }else{
                array[curIdx++] = copyArray[tRight++];
            }
        }
        int remain = mid - tLeft;
        for(int i = 0; i < remain; i++) {
            array[curIdx + i] = copyArray[tLeft + i];
        }
    }
    static void partition(int[] array, int left, int right) {
        if(left < right){
            int mid = (left + right) / 2;
            partition(array, left, mid);
            partition(array, mid+1, right);
            merge(array, left, right);
        }
    }
}
