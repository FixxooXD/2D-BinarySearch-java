public class sortedMatrix {
    public static void main(String[] args) {

    }
    //SEARCH IN THE ROW PROVIDED BETWEEN THE COLUMN PROVIDED
      static int[] BinarySearch(int[][] arr,int row,int cStart,int cEnd,int target){
                while (cStart<=cEnd){
                   int mid = cStart+(cEnd-cStart);
                   if (target==mid){
                       return new int[]{cStart,cEnd};
                   }
                   if (target > arr[row][mid]){
                       cStart = mid+1;
                   }
                   if (target<arr[row][mid]){
                       cStart = mid-1;
                   }
                }return new int[] {-1,-1};
      }
       static int[] bS(int[][] arr,int target){
        int rows = arr.length;
        int cols = arr[0].length;
        if (rows ==  1){
            return BinarySearch(arr,0,0,cols-1,target);
        }
           int rStart = 0;
           int rEnd = rows - 1;
           int cMid = cols / 2;

           // run the loop till 2 rows are remaining
           while (rStart < (rEnd - 1)) { // while this is true it will have more than 2 rows
               int mid = rStart + (rEnd - rStart) / 2;
               if (arr[mid][cMid] == target) {
                   return new int[]{mid, cMid};
               }
               if (arr[mid][cMid] < target) {
                   rStart = mid;
               } else {
                   rEnd = mid;
               }
           }

           // now we have two rows
           // check whether the target is in the col of 2 rows
           if (arr[rStart][cMid] == target) {
               return new int[]{rStart, cMid};
           }
           if (arr[rStart + 1][cMid] == target) {
               return new int[]{rStart + 1, cMid};
           }

           // search in 1st half
           if (target <= arr[rStart][cMid - 1]) {
               return BinarySearch(arr, rStart, 0, cMid-1, target);
           }
           // search in 2nd half
           if (target >= arr[rStart][cMid + 1] && target <= arr[rStart][cols - 1]) {
               return BinarySearch(arr, rStart, cMid + 1, cols - 1, target);
           }
           // search in 3rd half
           if (target <= arr[rStart + 1][cMid - 1]) {
               return BinarySearch(arr, rStart + 1, 0, cMid-1, target);
           } else {
               return BinarySearch(arr, rStart + 1, cMid + 1, cols - 1, target);
           }
       }
}