class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int from_days = 0;
        
        for(int mon = 1; mon < a; mon++){
            
            if(mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 ||
              mon == 10 || mon == 12){
                from_days += 31;
            }else if(mon == 2){
                from_days += 29;
            }else if(mon == 4 || mon == 6 || mon == 9 || mon == 11){
                from_days += 30;
            }
        }
        
        from_days += b;
        // System.out.println("totalDays : " + from_days);
        // System.out.println("요일 인덱스 : " +  from_days % 7);
        answer = day[from_days % 7];
        
       
        
        
        
        return answer;
    }
}