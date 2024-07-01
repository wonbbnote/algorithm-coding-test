class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, Boolean> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.put(0, true);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(Integer room: rooms.get(cur)){
                if(!visited.containsKey(room)){
                    queue.offer(room);
                    visited.put(room, true); 
                }
            }
        }

        if(visited.size() == rooms.size()){
            return true;
        }
        return false;
    }
}