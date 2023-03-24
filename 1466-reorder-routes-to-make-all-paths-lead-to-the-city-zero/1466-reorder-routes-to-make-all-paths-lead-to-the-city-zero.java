// class Solution {
//     public int minReorder(int n, int[][] connections) {
        
//     }
// }

import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        
        // Build graph with direction information
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            
            // Add directed edge from 'from' to 'to'
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            
            // Add undirected edge from 'to' to 'from'
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(-from);
        }
        
        // DFS traversal to check if path from current node leads to '0'
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited.add(0);
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(Math.abs(neighbor))) {
                    if (neighbor > 0) {
                        count++; // Reorder edge if direction is from neighbor to node
                    }
                    visited.add(Math.abs(neighbor));
                    stack.push(Math.abs(neighbor));
                }
            }
        }
        
        return count;
    }
}
