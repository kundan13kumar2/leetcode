package daily;

import java.util.HashSet;

public class MaxWordTyped {

    public static void main(String[] args) {
        MaxWordTyped obj=new MaxWordTyped();
        System.out.println(obj.canBeTypedWords("leet code","e"));
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        char[] brokenArray = brokenLetters.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<brokenArray.length;i++){
            set.add(brokenArray[i]);
        }
        int count=0;
        String[] words = text.split(" ");
        for (String word : words) {
            boolean flag=false;
            for(int i=0;i<word.length();i++){
                if(set.contains(word.charAt(i))){
                    flag=true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }

        }
        return count;
    }
}
