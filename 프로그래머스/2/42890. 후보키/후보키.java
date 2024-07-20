import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public int solution(String[][] relation) {
        int colLen = relation[0].length;
        int rowLen = relation.length;
        List<Set<Integer>> candidateKeys = new ArrayList<>();

        for (int length = 1; length <= colLen; length++) {
            List<Set<Integer>> combinations = new ArrayList<>();
		    // 속성 개수 별로 모든 조합을 만들어서 후보키 적합성을 검사한다.
            genCombinations(0, 0, length, new HashSet<>(), combinations, colLen);
			// 모든 속성 조합별로 후보키 적합성을 검사한다.
            for (Set<Integer> cols : combinations) {
                boolean minimality = true;
                Set<String> rowSet = new HashSet<>();

			    // 기존 후보키들과 비교해서 최소성 검사를 수행한다.
                for (Set<Integer> key : candidateKeys) {
                    if (cols.containsAll(key)) {
                        minimality = false;
                        break;
                    }
                }
			    
                // 최소성이 위반되면 다음 속성 조합의 후보키 검사를 진행한다.
                if (!minimality) {
                    continue;
                }

				// 속성 조합을 기반으로 유일성을 검사한다.
                for (String[] row : relation) {
                    StringBuilder rowStr = new StringBuilder();
                    for (int col : cols) {
                        rowStr.append(row[col]);
                    }
                    rowSet.add(rowStr.toString());
                }
				// 튜플 간 중복이 없으면 해당 속성 조합을 후보키로 선정한다.
                if (rowSet.size() == rowLen) {
                    candidateKeys.add(new HashSet<>(cols));
                }
            }
        }
        
	    // 후보키 개수를 반환한다.
        return candidateKeys.size();
    }

    private static void genCombinations(int start, int depth, int maxDepth, Set<Integer> curr, 
                                        List<Set<Integer>> resultCombs, int colLen) {
        if (depth == maxDepth) {
            resultCombs.add(new HashSet<>(curr));
            return;
        }
        for (int i = start; i < colLen; i++) {
            curr.add(i);
            genCombinations(i + 1, depth + 1, maxDepth, curr, resultCombs, colLen);
            curr.remove(i);
        }
    }
}