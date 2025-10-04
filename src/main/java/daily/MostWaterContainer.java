package daily;

public class MostWaterContainer {
    public static void main(String[] args) {
       // int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height={1,10,5,2,6,2,6,3,5,2,6,47,23,234,53,234,543,534,52,423,4,234,24,34,234,464,24,54,3,65,234,5434,543};
        //int[] height = {1,10,5,2,6,2,6,3,5,2,6,7,34,234,464,24,54,3,65,234,5434,543};
        MostWaterContainer container = new MostWaterContainer();
        System.out.println(container.maxArea(height));
    }

    public int maxArea(int[] height) {

        int i=0;
        int j=height.length-1;
        int maxWater = Integer.MIN_VALUE;
        while (i<j){
            int min =  Math.min(height[i],height[j]);
            maxWater = Math.max(maxWater, min*(j-i));
            if (height[i]<height[j]){
                i++;
            }else {
                j--;
            }
        }
        return maxWater;
    }
}
