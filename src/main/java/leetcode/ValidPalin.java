package leetcode;

public class ValidPalin {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i)!= s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "0P";
        String str = s.replaceAll("[^a-zA-Z]", "");
        ValidPalin palin = new ValidPalin();
        System.out.println(palin.isPalindrome(s));
    }
}
