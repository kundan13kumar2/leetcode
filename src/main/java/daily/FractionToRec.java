package daily;

import java.util.*;

public class FractionToRec {

    public static void main(String[] args) {
        FractionToRec fractionToRec = new FractionToRec();
        System.out.println(fractionToRec.fractionToDecimal(420, 226));
    }

    public String fractionToDecimal(int numerator, int denominator) {

        if(numerator==0) return "0";

        StringBuilder result = new StringBuilder();

        if ((numerator < 0 && denominator > 0) ||  (numerator > 0 && denominator < 0)) {
            result.append("-");
        }


        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        result.append(num/den);
        long remainder = num % den;
        if(remainder==0){
            return  result.toString();
        }

        result.append(".");
        Map<Long, Integer> indexMap = new HashMap<>();
        while (remainder != 0) {
            if (indexMap.containsKey(remainder)) {
                int pos = indexMap.get(remainder);
                result.insert(pos,"(");
                result.append(")");
                break;
            }
            indexMap.put(remainder, result.length());
            remainder*=10;
            result.append(remainder/den);
            remainder%=den;
        }
        return result.toString();
    }
}
