package daily;

public class LeaderBoard {
    public static void main(String[] args) {
        int[] arr = {100,50,40,20,10};

        LeaderBoard leaderBoard = new LeaderBoard();

        System.out.println(leaderBoard.getIdx(0, 4, 20, arr));
    }

    public int getIdx(int l, int r, int val, int[] arr) {

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == val) return mid+1;
            if (arr[mid] > val) {
                l = mid + 1;
            } else if (arr[mid] < val) {
                r = mid - 1;
            }
        }

        return l + 1;
    }
}
