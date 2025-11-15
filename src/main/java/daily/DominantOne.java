package daily;

public class DominantOne {
    public static void main(String[] args) {
        DominantOne dominantOne = new DominantOne();
        String str = "00011";
        System.out.println(dominantOne.numberOfSubstrings(str));
    }

    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i <= n - 1; i++) {
            int[] temp= new int[2];
            temp[s.charAt(i)-'0']=1;
            if (s.charAt(i)=='1') count++;
            for (int j = i + 1;j<n;j++){
                temp[s.charAt(j)-'0']++;
                if ((temp[0]*temp[0])<=temp[1]) {
                    count++;
                }
            }
        }

        return count;
    }
}
