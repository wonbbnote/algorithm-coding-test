import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        Queue<Integer> servers = new ArrayDeque<>();
        
        int server = 0;
        for(int i = 0; i < players.length; i++){
            int time = i;
            int player = players[i];
            int needed_player = player / m;
            
            // System.out.println("== time: " + time);
            
            while(!servers.isEmpty() && servers.peek() + k == time){
                servers.poll();
                server--;
            }
            
            // System.out.println("초기 server 개수: " + server);
            // System.out.println("게임 이용자수: " + player);
            // System.out.println("needed_player: " + needed_player);
            
            if(player >= m){
                if(server < needed_player){
                    int new_server = needed_player - server;
                    while(new_server > 0){
                        servers.add(time);
                        new_server--;
                        server++;
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}