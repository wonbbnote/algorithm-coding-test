import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        List<String> res = new ArrayList<>();
        Map<String, String> userList = new HashMap<>();
        
        for(int i = 0; i < record.length; i++){
            String[] command = record[i].split(" ");
            
            if(command[0].equals("Enter")){
                userList.put(command[1], command[2]);
                res.add("Enter "+command[1]);
                
            }else if(command[0].equals("Leave")){
                res.add("Leave "+command[1]);
                // userList.put(command[1], "");
                
            }else if(command[0].equals("Change")){
                userList.put(command[1], command[2]);
            }
        }
        
        
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++){
            String[] cmd = res.get(i).split(" ");
            if(cmd[0].equals("Enter")){
                answer[i] = userList.get(cmd[1]) + "님이 들어왔습니다.";
            }else if(cmd[0].equals("Leave")){
                answer[i] = userList.get(cmd[1]) + "님이 나갔습니다.";
            }
        }
        
        
        return answer;
    }
}