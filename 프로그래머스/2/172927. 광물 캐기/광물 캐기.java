class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        // 다이아몬드 곡괭이를 사용 -> 철 -> 돌
        int[][] table = new int[][] {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        int[] ore = new int[minerals.length];
        for(int i = 0; i < minerals.length; i++){
            ore[i] = minerals[i].equals("diamond") ? 0 : minerals[i].equals("iron") ? 1 : 2;
        }
        
        return dfs(0, picks, ore, table);
    }
    
    public int dfs(int start, int[] picks, int[] ore, int[][] table){
        if(start >= ore.length|| picks[0] + picks[1] + picks[2] == 0){
            return 0;
        }
        
        int best = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            if(picks[i] == 0) continue;
            
            int cost = 0;
            for(int j = start; j <  Math.min(start + 5, ore.length); j++){
                cost += table[i][ore[j]];
            }
            picks[i]--;
            best = Math.min(best, cost + dfs(start+5, picks, ore, table));
            picks[i]++;
            
        }
        return best;
        
        
        
    }
}