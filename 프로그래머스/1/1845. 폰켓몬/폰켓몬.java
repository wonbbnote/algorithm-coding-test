import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int kind = set.size();
        int halfN = nums.length/2;
        
        if(kind >= halfN){
            return halfN;
        }else{
            return kind;
        }

    }
}