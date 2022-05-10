package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch2 {

    boolean[] marked; // Is a shortest path to this vertex known?
    int[] edgeTo; // last vertex on known path to this vertex
    int s;


    public BreadthFirstSearch2(Graph g, int s) {
        this.marked = new boolean[g.V()];
        this.edgeTo = new int[g.V()];
        this.s = s;

        bfs(g, s);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (Integer w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

}
