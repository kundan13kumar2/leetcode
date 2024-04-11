package daily;

import java.util.Stack;

public class RemoveKDigits420 {

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 5));
    }

    public static String removeKdigits(String num, int k) {

        StringBuilder result = new StringBuilder();

        Stack<Character> charStack = new Stack<>();
        charStack.push(num.charAt(0));
        int i = 1;
        while (i<num.length()) {
            while (!charStack.isEmpty() && k > 0 && num.charAt(i) < charStack.peek()) {
                charStack.pop();
                k--;
            }
            charStack.push(num.charAt(i++));
        }

        while (k>0 && !charStack.empty()){
            charStack.pop();
            k--;
        }

        while (!charStack.isEmpty()){
            result.append(charStack.pop());
        }

        result.reverse();
        String finalResult = result.toString().replaceFirst("^0*","");
        if (finalResult.length() == 0 ) return  "0";
        return finalResult;
    }

}
