package leetcode;

public class CheckEqualDigits {
    public static void main(String[] args) {
        String s = "34789";
        CheckEqualDigits checkEqualDigits = new CheckEqualDigits();
        System.out.println(checkEqualDigits.hasSameDigits(s));
    }

    public boolean hasSameDigits(String s) {
        char[] arr = s.toCharArray();
        int k = arr.length;
        while (k > 2) {
            for (int i = 0; i < k - 1; i++) {
                int digit = ((arr[i] - '0') + (arr[i + 1] - '0')) % 10;
                System.out.println(digit);
                arr[i] = Character.forDigit(digit, 10);
            }
            System.out.println(arr);
            k--;
        }
        return arr[0] == arr[1];
    }
}
