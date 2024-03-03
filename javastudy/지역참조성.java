package javastudy;

public class 지역참조성 {
    public static void main(String[] args) {
        int[][] arr = new int[10000][10000];
        long start = System.nanoTime();
        widthFor(arr);
        long end = System.nanoTime();
        System.out.println(end - start);

    }
    public static void widthFor(int[][] arr) {
        for(int i = 0; i < arr.length; i ++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 1;
            }
        }
    }
    public static void heightFor(int[][] arr) {
        for(int i = 0; i < arr.length; i ++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[j][i] = 1;
            }
        }
    }
}
