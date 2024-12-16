class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] arr = new int[n+1][n+1];
        
        for(int i = 0; i < results.length; i++){
            arr[results[i][0]][results[i][1]] = 1;
            arr[results[i][1]][results[i][0]] = -1;
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(arr[i][k] == 1 & arr[k][j] == 1){
                        arr[i][j] = 1;
                        arr[j][i] = -1;
                    }else if(arr[i][k] == -1 & arr[k][j] == -1){
                        arr[i][j] = -1;
                        arr[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= n; j++){
                if(arr[i][j] != 0){ count++; }
            }
            if(count == n-1){
                answer++;
            }
        }
        
        
        return answer;
    }
}