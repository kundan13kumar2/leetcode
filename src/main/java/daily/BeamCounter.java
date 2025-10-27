package daily;

import java.util.ArrayList;
import java.util.List;

public class BeamCounter {

    public static void main(String[] args) {
        //String bank[] = {"011001", "000000", "010100", "001000"};
        String bank[] = {"000", "111", "000"};
        BeamCounter beamCounter = new BeamCounter();
        System.out.println(beamCounter.numberOfBeams(bank));
    }

    public int numberOfBeams(String[] bank) {

        List<Integer> list = new ArrayList<>();
        int ans = 0;
        for (String s : bank) {
            char[] arr = s.toCharArray();
            int count = 0;
            for (char c : arr) {
                if (c == '1') {
                    count++;
                }
            }
            if (count > 0) {
                list.add(count);
            }
        }
        if (list.size() == 1) {
            return 0;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            ans += (list.get(i) * list.get(i + 1));
        }
        return ans;
    }
}
