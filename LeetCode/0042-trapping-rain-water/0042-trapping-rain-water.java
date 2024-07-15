// 1. 투 포인터 사용
import java.util.*;
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int answer = 0;

        int left_std = -1;
        int right_std = -1;
        
        while(true){
            if(left == right){
                break;
            }else if(height[left] < height[right]){
                if(left_std < height[left]){
                    left_std = height[left];
                }
                left++;
                if(left_std > height[left]){
                    answer += left_std - height[left];
                }
            }else{
                if(right_std < height[right]){
                    right_std = height[right];
                }
                right--;
                if(right_std > height[right]){
                    answer += right_std - height[right];
                }
            }
        }

        return answer;
        
    }
}