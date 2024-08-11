import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> idMap = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            idMap.put(id_list[i], i);
        }
        // System.out.println(idMap);
        
        // String[] report로 신고한 사람들을 저장
        // 중복 1회로 간주해야 하기 때문에 set으로 만들기
        Map<String, Set<String>> reportPeople = new HashMap<>();

        for(int i = 0; i < report.length; i++){
            String[] r = report[i].split(" ");
            
            if(!reportPeople.containsKey(r[1])){
                reportPeople.put(r[1], new HashSet<>());
                reportPeople.get(r[1]).add(r[0]);
            }else{
                reportPeople.get(r[1]).add(r[0]);
            }
        }
        // System.out.println(reportPeople);
        
        // k번 이상 신고당한 사람들을 찾기
        // 해당 사람들을 신고했던 사람들을 찾아 int[] answer에 번호 증가
        for(String key : reportPeople.keySet()){
            if(reportPeople.get(key).size() >= k){
                for(String p: reportPeople.get(key)){
                    answer[idMap.get(p)]++;
                }
            }
        }
        // System.out.println(Arrays.toString(answer));
        
        
    
        
        
        
        
        return answer;
    }
}