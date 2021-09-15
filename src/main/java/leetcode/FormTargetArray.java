package leetcode;

public class FormTargetArray {

    public int minNumberOperations(int[] target) {
        if (target.length == 1) return target[0];

        int res = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] - target[i - 1] > 0)
                res += target[i] - target[i - 1];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] target = {3, 1, 5, 4, 2};
        FormTargetArray targetArray = new FormTargetArray();
        System.out.println(targetArray.minNumberOperations(target));
    }
}
