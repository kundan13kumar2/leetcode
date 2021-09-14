package leetcode;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {

        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        int n = arr.length;
        while (i < j) {
            while (i < n && !((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z'))) {
                i++;
            }
            while (j >= 0 && !((arr[j] >= 'a' && arr[j] <= 'z') || (arr[j] >= 'A' && arr[j] <= 'Z'))) {
                j--;
            }
            if (i >= j || i >= n || j <= 0) break;
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return String.valueOf(arr);

    }

    public static void main(String[] args) {
        String str = "Test1ng-Leet=code-Q!";
        ReverseOnlyLetters onlyLetters = new ReverseOnlyLetters();
        System.out.println(onlyLetters.reverseOnlyLetters(str));
    }

    /**
     * Qedo1ct-eeLg=ntse-T!
     */
}
