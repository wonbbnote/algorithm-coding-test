class Solution {
    public int[] findErrorNums(int[] nums) {

        int[] res = new int[2];
        boolean[] bool = new boolean[nums.length + 1];

        for(int i = 0; i < nums.length; i++){
            if(bool[nums[i]]){
                bool[nums[i]] = false;
                res[0] = nums[i];
            }
            bool[nums[i]] = true;
        }

        for(int i = 1; i <= nums.length; i++){
            if(!bool[i]){
                res[1] = i;
            }
        }

        return res;

        
    }
}