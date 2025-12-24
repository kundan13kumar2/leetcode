package daily;

import java.util.*;

// Not good for leetcode/ incorrect logic
public class ConcatWord2 {

    public static void main(String[] args) {

        String s = "barfoothefoobarman";
        String[] words = {"word","good","best","good"};
        ConcatWord2 cw = new ConcatWord2();
        System.out.println(cw.findSubstring(s,words));
    }

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        int i = 0;
        int j = 0;
        int n = s.length();
        int p = words.length;
        int k = words[0].length();
        List<String> wordsList = Arrays.asList(words);
        Collections.sort(wordsList);
        while (j <= (n - k) ) {
            String subStr = s.substring(j,j+k);
            if ((j-i)>=(p*k)){
                if (queueContains(queue, wordsList)) {
                    ans.add(i);
                }
                queue.poll();
                queue.offer(subStr);
                i=i+k;
            }else {
                queue.offer(subStr);
            }
            j=j+k;
        }
        if (queueContains(queue, wordsList)) {
            ans.add(i);
        }
        return ans;
    }

    private boolean queueContains(Queue<String> queue,List<String> wordList){
        List<String> list = new ArrayList<>(queue);
        Collections.sort(list);

        if (list.size() != wordList.size()) {
            return false;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (!wordList.get(i).equals(list.get(i))) {
                return false;
            }
        }

        return true;
    }
}
