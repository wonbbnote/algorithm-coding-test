import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        int[] answer = {};
        // 정답 리스트 정의
        List<Integer> res = new ArrayList<>();
        
        // terms를 돌면서 Map에 약관종류: 유효기간을 저장
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String[] s = terms[i].split(" ");
            map.put(s[0], Integer.valueOf(s[1]));   
        }
        
        // privacies를 돌면서 약관 종류를 확인하고, 해당 약관의 달 수를 더한다.
        // today와 비교
        for(int i = 0; i < privacies.length; i++){
            String[] p = privacies[i].split(" ");
            String privacy = p[0];
            int term = map.get(p[1]);
            
            // 약관 유효기간 마감일 구하기
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
            Date date = format.parse(privacy);
            Date todate = format.parse(today);
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, term);
            String strdate = format.format(cal.getTime());
            date = format.parse(strdate);
            
            
            // today와 비교
            if(date.compareTo(todate) <= 0) {
                res.add(i + 1);
            }
            
        }
        
        // 마지막 정답 리스트를 int[]로 변환
        answer = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        Arrays.sort(answer);

        
        return answer;
    }
}