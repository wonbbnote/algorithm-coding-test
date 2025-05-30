class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        
        for(int i = 0; i < schedules.length; i++){
            int day = startday;
            int setTime = schedules[i] / 100;
            int setMinute = schedules[i] % 100;
            
            if(setMinute < 50){
                setMinute += 10;
            }else{
                setTime += 1;
                setMinute -= 50;
            }
            
            boolean gift = true;
            
            for(int j = 0; j < timelogs[i].length; j++){
                
                if(day != 6 && day != 7){
                    int dayTime = timelogs[i][j] / 100;
                    int dayMinute = timelogs[i][j] % 100;
                    
                    if(dayTime > setTime || dayTime == setTime && dayMinute > setMinute){
                        gift = false;
                        break;
                    }
                }
                
                if(day == 7){
                    day = 1;
                }else{
                    day++;
                }
            }
            
            if(gift){
                answer++;
            }
        }
        
        
        
        return answer;
    }
}