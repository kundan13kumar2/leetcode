package daily;

import java.util.Arrays;

public class AppleRedistribution {

    public static void main(String[] args) {
        AppleRedistribution ar = new AppleRedistribution();
        int[] apple = {10, 20, 30};
        int[] capacity = {15, 25, 10, 20, 30};
        int result = ar.minimumBoxes(apple, capacity);
        System.out.println(result); // Output: 3
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = Arrays.stream(apple).sum();

        Arrays.sort(capacity);
        int counter = 0;
        int j = capacity.length - 1;
        while (totalApples > 0) {
            totalApples -= capacity[j];
            counter++;
            j--;
        }
        return counter;
    }


}
