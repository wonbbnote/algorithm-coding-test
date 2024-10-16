import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {-1, 0});
        String s = begin;
        
        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            if(polled[0] != -1){
                s = words[polled[0]];
            }
            
            if(s.equals(target)){
                return polled[1];
            }
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i]){
                    int diff = 0;
                    for(int j = 0; j < words[i].length(); j++){
                        if(s.charAt(j) != words[i].charAt(j)){
                            diff++;
                        }
                    }
                    
                    if(diff == 1){
                        queue.add(new int[] {i, polled[1]+1});
                        visited[i] = true;
                    }
                }
            }
        }

        
        return 0;
    }
}