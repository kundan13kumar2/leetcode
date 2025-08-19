package leetcode;

public class MaxBalloons {

    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i) - 'a']++;
        }


        String target = "balloon";
        int res = 0;
        while (true) {
            for (char ch : target.toCharArray()) {
                freq[ch - 'a']--;
                if (freq[ch - 'a'] < 0) return res;
            }
            res++;
        }

    }

    public static void main(String[] args) {
        String str = "balllllllllllloooooooooon";
        MaxBalloons balloons = new MaxBalloons();
        System.out.println(balloons.maxNumberOfBalloons(str));
    }
}
