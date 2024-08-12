class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        //✅ 각 숫자를 key값으로 하여 해시테이블을 만든다.
        Map<Integer, Boolean> numsHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsHashMap.put(nums[i], true);
        }
        //✅ 해시테이블을 순회한다.
        for (int num : numsHashMap.keySet()) {
	        //✅ 만약 이전 숫자가 존재하지 않는다면, 개수를 1로 초기화한다.
            if (!numsHashMap.containsKey(num - 1)) {
                int cnt = 1;
                int target = num + 1;
	            //✅ 다음 숫자가 존재할 때까지 개수를 1씩 증가시킨다.
                while (numsHashMap.containsKey(target)) {
                    target++;
                    cnt++;
                }
	            //✅ 연속된 숫자 개수 최댓값을 업데이트한다.
                longest = Math.max(longest, cnt);
            }
        }
        return longest; 
    }
}