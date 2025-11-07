public class TestTT {

    public static void main(String[] args) {
        /*
        [0],
[1, 2],
[2, 1],
[0, 1, 2, 3, 4, 5],
[1, 2, 3, 4, 5, 6, 7, 0],
[3,4,5,1,2],
[6,7,0,1,2,3,4,5]

         */


        int[] arr = {6,7,0,1,2,3,4,5};

        TestTT tt = new TestTT();

        System.out.println(tt.findMinIndex(arr));
    }

    public int findMinIndex(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > arr[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return arr[l];
    }

}
