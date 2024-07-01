import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {

        List<Integer> first_nums = new ArrayList<>();
        for(int num: nums){
            first_nums.add(num);
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            if(nums[left] + nums[right] < target){
                left += 1;
            }else if(nums[left] + nums[right] > target){
                right -= 1;
            }else{
                return new int[] {first_nums.indexOf(nums[left]), first_nums.lastIndexOf(nums[right])};
            }
        }
        return new int[] {-1, -1};
        
    }
}