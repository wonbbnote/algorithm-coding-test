import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        
        Map<String, Integer> cache = new HashMap<>();
        int num = 0;
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toUpperCase();
            
            if(cache.containsKey(city)){
                cache.put(city, num++);
                answer += 1;
                
            }else if(cache.size() < cacheSize){
                cache.put(city, num++);
                answer += 5;
                
            }else if(cache.size() >= cacheSize){
            
                if(cacheSize > 0){
                    Integer minValue = Collections.min(cache.values());
                    for (String key : cache.keySet()) {
                        if(cache.get(key) == minValue){
                            cache.remove(key);
                            break;
                        }
                    }
                    cache.put(city, num++);
                }
                
                answer += 5;
            }
            
            // System.out.println(answer);
            // System.out.println(cache);
        }
        
        return answer;
    }
}