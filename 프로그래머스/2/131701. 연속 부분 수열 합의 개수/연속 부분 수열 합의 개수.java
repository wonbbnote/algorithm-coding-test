import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        int[] ele = new int[elements.length * 2];
        int n = 0;
        
        System.arraycopy(elements, 0, ele, 0, elements.length);
        System.arraycopy(elements, 0, ele, elements.length, elements.length);
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                int num = 0;
                for(int z = 0; z < i; z++){
                    num += ele[j+z];
                }
                set.add(num);
            }
        }
        
        return set.size();
    }
}