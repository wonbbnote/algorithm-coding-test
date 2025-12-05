class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int videoSec = Integer.valueOf(video_len.split(":")[0]) * 60 + Integer.valueOf(video_len.split(":")[1]);
        
        int openingStartSec = Integer.valueOf(op_start.split(":")[0]) * 60 + Integer.valueOf(op_start.split(":")[1]);
        int openingEndSec = Integer.valueOf(op_end.split(":")[0]) * 60 + Integer.valueOf(op_end.split(":")[1]);
        
        int minute = Integer.valueOf(pos.split(":")[0]);
        int second = Integer.valueOf(pos.split(":")[1]);
        
        int totalSec = minute * 60 + second;            
        
        for(int i = 0; i < commands.length; i++){
            
            // 오프닝 건너뛰기: 오프닝 구간의 경우 오프닝이 끝나는 위치로
            if(totalSec >= openingStartSec && totalSec <= openingEndSec){
                totalSec = openingEndSec;
            }
            
            // 10초 전: "prev" 입력 시 10초 미만인 경우 처음위치
            if(commands[i].equals("prev")){
                if(totalSec < 10){
                    totalSec = 0;
                }else{
                    totalSec -= 10;
                }
            }
        
            // 10초 후: "next" 입력 시 10초 후로 이동 10초 미만 남은경우 마지막
            if(commands[i].equals("next")){
                if(totalSec > videoSec - 10){
                    totalSec = videoSec;
                }else{
                    totalSec += 10;
                }
            }
            
            // 오프닝 건너뛰기: 오프닝 구간의 경우 오프닝이 끝나는 위치로
            if(totalSec >= openingStartSec && totalSec <= openingEndSec){
                totalSec = openingEndSec;
            }
        }
        
        String resMinute = String.format("%02d", totalSec / 60);
        String resSecond = String.format("%02d", totalSec % 60);
        
        answer = resMinute + ":" + resSecond;
        
        return answer;
    }
}