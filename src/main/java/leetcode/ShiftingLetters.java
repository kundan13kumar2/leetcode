package leetcode;

public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        int[] temp = new int[shifts.length];
        temp[shifts.length - 1] = shifts[shifts.length - 1] % 26;
        for (int i = shifts.length - 2; i >= 0; i--) {
            temp[i] = (temp[i + 1] % 26 + shifts[i] % 26) % 26;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((temp[i] + s.charAt(i)) > 'z') {
                int t = s.charAt(i);
                int p = temp[i] + t;
                sb.append((char) (p - 'z' + 'a' - 1));
            } else
                sb.append((char) (temp[i] + s.charAt(i)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        ShiftingLetters sfl = new ShiftingLetters();
        System.out.println(sfl.shiftingLetters("ruu", new int[]{26, 9, 17}));

    }
}
