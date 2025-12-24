package daily;

public class LazyPropagation {

    int[] segmentTree;
    int n;

    public static void main(String[] args) {

    }

    void buildSegmentTree(int[] nums, int index, int l, int r) {

        if (l == r) {
            segmentTree[index] = nums[l];
            return;
        }

        int mid = (l + r) / 2;

        buildSegmentTree(nums, 2 * index + 1, l, mid);
        buildSegmentTree(nums, 2 * index + 2, mid + 1, r);

        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];

    }

}
