package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConcatWord {
    public static void main(String[] args) {
        ConcatWord cw = new ConcatWord();
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(cw.findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int p = words.length;
        int k = words[0].length();
        int n = s.length();
        List<String> wordList = Arrays.asList(words);
        Collections.sort(wordList);
        int i  = 0;
        int j = p*k;
        while(j<=n){
            String subStr = s.substring(i, j);
            if (check(wordList,subStr)) {
                ans.add(i);
            }
            i++;
            j++;
        }

        return ans;
    }

    private boolean check(List<String> wordList, String s){
        List<String> slist = new ArrayList<>();
        int k = wordList.get(0).length();
        int i = 0;
        while (i<= s.length()-k){
            slist.add(s.substring(i,i+k));
            i+=k;
        }
        Collections.sort(slist);
        if (slist.size()!=wordList.size()) return false;

        for (i = 0; i < wordList.size(); i++) {
            if (!wordList.get(i).equals(slist.get(i))) {
                return false;
            }
        }

        return true;
    }
}
