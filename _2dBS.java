import java.util.Arrays;

public class _2dBS {
    public static void main(String[] args) {
      int[][] arr  = {
                      {1,2,3,4},
                      {5,6,7,8},
                      {9,10,11,12}
              };
        System.out.println(arr[0].length);
        System.out.println(arr.length);
        System.out.println(Arrays.toString(BinarySearch(arr,9)));
    }
    static int[] BinarySearch(int[][] arr,int target){
        int row = 0;
        int col = arr.length-1;
        while (row<arr.length && col>=0){
            if(target == arr[row][col]){
                return  new int[] {row,col};
            }
            else if (arr[row][col] < target){
                row++;
            }
            else col--;
        }
        return new int[] {-1,-1};

    }

}
