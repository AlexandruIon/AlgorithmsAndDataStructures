package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {

    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public BreadthFirstSearch(Graph graph, int source) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.source = source;

        bfs(graph, source);
    }

    public void bfs(Graph graph, int s) {
        Queue<Integer> queue = new LinkedList<Integer>();
        marked[s] = true;

        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Integer w : graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = s;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != source; x = edgeTo[x])
            path.push(x);
        path.push(source);
        return path;
    }

}
