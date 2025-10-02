package daily;

import java.util.*;

public class RepeatDna {
    public static void main(String[] args) {
        RepeatDna sol = new RepeatDna();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(sol.findRepeatedDnaSequences(s));
    }

    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> res = new HashSet<>();
        Set<String> dna = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str =   s.substring(i, i + 10);
            if (!dna.add(str)) {
                res.add(str);
            }
        }

        return new ArrayList<>(res);

      /*


        List<String> ans = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            int freq = freqMap.getOrDefault(str, 0);
            freqMap.put(str, freq + 1);
        }
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }
        return ans;*/
    }

}
