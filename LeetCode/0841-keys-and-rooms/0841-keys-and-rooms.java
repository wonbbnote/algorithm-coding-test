class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // rooms에 각방에 있는 키 번호가 담겨있고 0번 방은 열려있다. 각 방에 있는 키로 방문을 열 수 있다. 
        // 모든 방을 방문할 수 있으면 true, 없으면 false 
        int n = rooms.size();
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, boolean[] visited, int now){

        visited[now] = true;
        for(Integer key : rooms.get(now)){
            if(!visited[key]){
                dfs(rooms, visited, key);
            }
        }
    }
}