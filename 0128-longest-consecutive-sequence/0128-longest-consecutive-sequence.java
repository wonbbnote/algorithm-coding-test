class Solution {
    public int longestConsecutive(int[] nums) {
        
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num: nums){
            map.put(num, true);
        }

        int answer = 0;
        for(int key: map.keySet()){
            if(!map.containsKey(key - 1)){
                int cnt = 1;
                int target = key + 1;
                while(map.containsKey(target)){
                    cnt++;
                    target++;
                }
                answer = Math.max(answer, cnt);
            }
        }
        
        return answer;

    }
}