import java.util.*;
class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        List<Integer> result = new ArrayList<>();
        List<int[]> case_list = new ArrayList<>();
        backtracking(k, dungeons, case_list, result);
        for(Integer res: result){
            if(answer < res){
                answer = res;
            }
        }
        return answer;
    }
    
    public void backtracking(int k, int[][] dungeons, List<int[]> case_list, List<Integer> result){
        
        boolean check = true;
        for(int[] dungeon: dungeons){
            if(!case_list.contains(dungeon)){
                if(k >= dungeon[0] && k - dungeon[1] >= 0){
                    check = false;
                    case_list.add(dungeon);
                    backtracking(k - dungeon[1], dungeons, case_list, result);
                    case_list.remove(case_list.size() - 1);
                }
            }
        }
        if(check){
            result.add(case_list.size());
            return;
        }
    }
}