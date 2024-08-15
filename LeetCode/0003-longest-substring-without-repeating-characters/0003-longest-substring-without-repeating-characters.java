class Solution {
    public int lengthOfLongestSubstring(String s) {

        int start = 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        for(int end = 0; end < s.length(); end++){
            if(map.containsKey(s.charAt(end))){
                start = Math.max(start, map.get(s.charAt(end))+1);
            }
            map.put(s.charAt(end), end);
            maxLength = Math.max(maxLength, end-start+1);
        }

        return maxLength;

        
    }
}