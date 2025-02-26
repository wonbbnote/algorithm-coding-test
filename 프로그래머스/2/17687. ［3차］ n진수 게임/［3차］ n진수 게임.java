import java.util.*;
class Solution {
    private static Map<Integer, Character> map = new HashMap<>();
    
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');
         
        int num = 0;
        int neededNum = p + m * (t-1);
        
        List<Character> list = new ArrayList<>();
        list.add('0');
        
        while(list.size() <= neededNum){
            num++;
            char[] arr = (Nth(num, n)).toCharArray();
            for(char c: arr){
                list.add(c);
            }
        }
        // System.out.println(list);
        
        int start = p-1;
        for(int i = 0; i < t; i++){
            answer += list.get(start);
            start += m;
        }
        return answer;
    }
    
    public String Nth(int num, int n){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while(num > 0){
            int remainder = num % n;
            stack.push(remainder);
            num /= n;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            int popped = stack.pop();
            if(n > 10 && popped >= 10){
                sb.append(map.get(popped));
            }else{
                sb.append(popped);
            }
        }
        
        return sb.toString();
    
    }
}