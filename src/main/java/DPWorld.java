import java.util.Stack;

public class DPWorld {


    public static String decode(String str) {

        Stack<Character> s = new Stack<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '[') continue;
            else if (arr[i] != ']') s.push(arr[i]);
            else {
                StringBuilder temp = new StringBuilder();
                int n = -1;
                while (!s.isEmpty()) {
                    char ch = s.pop();
                    if (ch >= '1' && ch <= '9') {
                        n = Integer.parseInt(String.valueOf(ch));
                        break;
                    } else {
                        temp.append(ch);
                    }
                }

                String ss = temp.reverse().toString();
                StringBuilder ss1 = new StringBuilder(ss);
                int p = 1;
                while (p < n) {
                    ss1.append(ss);
                    p++;
                }
                
                for (int k = 0; k < ss1.length(); k++)
                    s.push(ss1.charAt(k));
                
            }
        }

        StringBuilder res = new StringBuilder("");
        while (!s.isEmpty()) {
            res.append(s.pop());
        }
        return res.reverse().toString();
        
        
        /*
        abccdcdcdefabccdcdcdef
        abccdcdcdefabccdcdcdef
        
         */
    }


    public static void main(String[] args) {
       /* String[] arr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int num = 12345678;
        int rem = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            rem = num % 26;
            num /= 26;
            if (rem == 0) {
                sb.append("Z");
                num--;
            } else sb.append(arr[rem - 1]);
        }
        System.out.println(sb.reverse());*/

        String str = "3[a]2[bc]";
        System.out.println(decode(str));

    }
}
