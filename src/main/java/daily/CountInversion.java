package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CountInversion {

    public static void main(String[] args) {
        int[] arr = {5,2,6,1};

        CountInversion countInversion = new CountInversion();
        System.out.println(countInversion.countSmaller(arr));
    }

    public List<Integer> countSmaller(int[] nums) {
        int len=nums.length;
        ArrayList<Integer> list=new ArrayList<>();
        Integer[] res=new Integer[len];
        for(int i=len-1;i>=0;i--){
            int idx=binarySearch(list,nums[i]);
            res[i]=idx;
            list.add(idx,nums[i]);
        }
        return Arrays.asList(res);
    }

    private int binarySearch(List<Integer> list,int num){
        int left=0,right=list.size();
        while(left<right){
            int mid=left+(right-left)/2;
            if(list.get(mid)<num)left=mid+1;
            else right=mid;
        }
        return left;
    }


}
