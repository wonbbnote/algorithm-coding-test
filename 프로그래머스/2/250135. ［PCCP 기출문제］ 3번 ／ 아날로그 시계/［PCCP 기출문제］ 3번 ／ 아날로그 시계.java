class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        
        // 초침이 시침/분침과 겹칠 때마다 알람
        // 특정 시간동안 알람이 울린 횟수
        
        int startTime = h1 * 3600 + m1 * 60 + s1;
        int endTime = h2 * 3600 + m2 * 60 + s2;
        
        int alarm = 0;
        
        if(startTime == 0 || startTime == 12 * 3600){
            alarm++;
        }
        
        
        while(startTime < endTime){
            
            double h = startTime / 120.0 % 360;
            double m = startTime / 10.0 % 360;
            double s = startTime * 6.0 % 360;
            
            double nextH = (startTime + 1) / 120.0 % 360;
            double nextM = (startTime + 1) / 10.0 % 360;
            double nextS = (startTime + 1) * 6.0 % 360;
            
            if(nextH == 0){
                nextH = 360;
            }
            if(nextM == 0){
                nextM = 360;
            }
            if(nextS == 0){
                nextS = 360;
            }

            if(s < h && nextS >= nextH){
                alarm++;
            }
            if(s < m && nextS >= nextM){
                alarm++;
            }
            
            if(nextS == nextH && nextH == nextM){
                alarm--;
            }

            startTime++;
            
        }
        
        
        return alarm;
    }
}