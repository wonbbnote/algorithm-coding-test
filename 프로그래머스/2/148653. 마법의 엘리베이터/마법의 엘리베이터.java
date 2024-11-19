import java.util.*;
class Solution {
    public int solution(int storey) {
        
        String s = String.valueOf(storey);
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            arr[i] = s.charAt(i) - '0';
        }
        int answer = 0;
        // System.out.println(Arrays.toString(arr));
        
        for(int i = arr.length - 1; i >= 0; i--){
            
            int curr = arr[i];
            
            if(i == 0 && curr > 5){
                answer += 11 - curr;
                break;
            }else if(i == 0 && curr <= 5){
                answer += curr;
                break;
            }
            
            int forward = arr[i - 1];
            
            
            if(curr > 5){
                answer += 10 - curr;
                arr[i-1]++;
                
            }else if(curr < 5){
                answer += curr;
                
            }else{
                
                answer += 5;
                
                if(forward >= 5){
                    arr[i-1]++;
                }
            }
            
           
            
        }

        
        return answer;
    }
}