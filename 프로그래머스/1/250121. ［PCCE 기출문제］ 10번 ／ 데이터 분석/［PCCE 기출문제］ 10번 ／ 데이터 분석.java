import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        List<int[]> lst = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            if(data[i][map.get(ext)] < val_ext){
                lst.add(data[i]);
            }
        }
        
        int[][] answer = new int[lst.size()][4];
        for(int i = 0; i < lst.size(); i++){
            answer[i] = lst.get(i);
        }
        
        Arrays.sort(answer, Comparator.comparingInt((int[] o) -> o[map.get(sort_by)])); 
        
        return answer;
    }
}