import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] a = new int[N];
        
        double[][] res = new double[N][2];
        double denominator = stages.length;
        for(int i = 1; i <= N; i++){
            int user = 0;
            for(int j = 0; j < stages.length; j++){
                if(stages[j] == i){
                    user++;
                }
            }
            res[i-1] = new double[] {i, denominator == 0 ? 0 : (double) user / denominator};
            // System.out.println("denominator: "+denominator);
            // System.out.println("user: "+user);
            denominator -= user;
        }
        
        Arrays.sort(res, (o1, o2) -> Double.compare(o2[1], o1[1]));
        
        for(int i = 0; i < res.length; i++){
            System.out.println(Arrays.toString(res[i]));
        }
        
        for(int i = 0; i < N; i++){
            a[i] = (int) res[i][0];
        }

        return a;
    }
}