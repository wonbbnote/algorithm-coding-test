import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        
        String[] sorted = new String[strs.length];
        for(int i = 0; i < strs.length; i++){
            sorted[i] = getHash(strs[i]);
        }

        Map<String, List<Integer>> map = new HashMap<>();
        int[] classified = new int[strs.length];
        for(int i = 0; i < sorted.length; i++){
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i], new ArrayList<>());
                map.get(sorted[i]).add(i);
            }else{
                map.get(sorted[i]).add(i);
            }
        }

        for (String key : map.keySet()) {
            List<String> caseOne = new ArrayList<>();
            for(Integer value: map.get(key)){
                caseOne.add(strs[value]);
            }
            answer.add(caseOne);
        }
        return answer;
        
    }

    public String getHash(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }


}