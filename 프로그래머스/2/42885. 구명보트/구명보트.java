import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        // System.out.println(Arrays.toString(people));
        
        int point = people.length - 1;
        boolean[] boarded = new boolean[people.length];
        for(int i = 0; i < people.length; i++){
            
            if(!boarded[i]){
                boarded[i] = true;
            }else{
                continue;
            }
            
            while(point >= 0 && people[i] + people[point] > limit){
                point--;
            }
            
            if(i < point){
                boarded[point] = true;
                point--;
            }
            
            answer++;
            
        }
        
        return answer;
    }
}