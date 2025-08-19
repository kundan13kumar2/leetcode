package week258;

public class ReversePrefix {
    public String reversePrefix(String word, char ch) {

        char[] arr = word.toCharArray();
        int i = 0;
        while (i < word.length()) {

            if (arr[i] == ch) break;
            i++;
        }
        if (i == arr.length) return word;
        else {

            int j = 0;
            while (j < i) {
                char t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
                j++;
                i--;
            }
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        ReversePrefix r = new ReversePrefix();
        System.out.println(r.reversePrefix("abcd", 'z'));
    }
}
