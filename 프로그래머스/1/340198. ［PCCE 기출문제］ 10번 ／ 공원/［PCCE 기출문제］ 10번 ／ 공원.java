import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        
        int[][] arr = new int[park.length][park[0].length];
         
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length; j++){
                
                for(int k = 0; k <= mats.length - 1; k++){
                    
                    if(park[i][j].equals("-1")){
                        if(isVacant(park, mats[k], new int[] {i, j})){
                            arr[i][j] = mats[k];
                            answer = Math.max(answer, mats[k]);
                        }
                    }
                }
                
            }
        }
        
        for(int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        
        if(answer == 0){
            return -1;
        } 
        return answer;
        
    }
    
    public boolean isVacant(String[][] park, int n, int[] curr){
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int r = curr[0] + i;
                int c = curr[1] + j;
                
                if(r >= park.length || c >= park[0].length){
                    return false;
                }
                
                if(!park[r][c].equals("-1")){
                    return false;
                }
            }
        }
        return true;
        
    }
}