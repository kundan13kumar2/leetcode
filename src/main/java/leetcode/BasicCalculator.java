package leetcode;

import java.util.Stack;

public class BasicCalculator {


    public int calculate(String s) {

        s = s.replace(" ", "");
        int res = 0;
        Stack<String> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == '+' || s.charAt(i) == ' ') {
                i++;
                continue;
            }

            StringBuilder sb = new StringBuilder();
            if (s.charAt(i) == '-') {
                sb.append(s.charAt(i));
                i++;
            }
            while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
                i++;
            }
//            if (sb.length() > 1 && sb.charAt(0) != '-')
//                i = i - 1;
            if (sb.length() == 0) {
                if (s.charAt(i) == ')') {
                    i++;
                    int tempRes = 0;
                    String prev = "";
                    String curr = "";
                    while (!st.isEmpty()) {
                        if (st.peek().charAt(0) == '(') {
                            st.pop();
                            break;
                        }
                        curr = st.pop();
                        if (curr.length() == 1 && curr.charAt(0) == '-') {
                            res -= Integer.parseInt(prev);
                            res += -1 * Integer.parseInt(prev);
                        } else if (curr.charAt(0) == '-') {
                            String temp = curr.substring(1);
                            tempRes -= Integer.parseInt(temp);
                        } else
                            tempRes += Integer.parseInt(curr);
                        prev = curr;
                    }
                    st.push(String.valueOf(tempRes));
                } else
                    st.push(String.valueOf(s.charAt(i++)));
            } else st.push(sb.toString());
        }
        String prev = "";
        String curr = "";
        while (!st.isEmpty()) {
            curr = st.pop();
            if (curr.length() == 1 && curr.charAt(0) == '-') {
                res -= Integer.parseInt(prev);
                res += -1 * Integer.parseInt(prev);
            } else if (curr.charAt(0) == '-') {
                String temp = curr.substring(1);
                res -= Integer.parseInt(temp);
            } else
                res += Integer.parseInt(curr);
            prev = curr;
        }

        return res;
    }

    public static void main(String[] args) {
        BasicCalculator bsc = new BasicCalculator();
        System.out.println(bsc.calculate("(7)-(0)+(4)"));
    }
}
