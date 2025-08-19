package week258;

public class MaxProductPalin {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public int recur(char[] arr, String s, String p, int pos, int max) {
        if (arr.length == pos) {
            if (isValid(s) && isValid(p))
                max = Math.max(max, s.length() * p.length());
            return max;

        }

        return Math.max(recur(arr, s + arr[pos], p, pos + 1, max),
                Math.max(recur(arr, s, p + arr[pos], pos + 1, max),
                        recur(arr, s, p, pos + 1, max)));

    }


    public int maxProduct(String s) {
        return recur(s.toCharArray(), "", "", 0, 0);
    }

    public static void main(String[] args) {
        MaxProductPalin palin = new MaxProductPalin();
        System.out.println(palin.maxProduct("leetcodecom"));
    }
}
