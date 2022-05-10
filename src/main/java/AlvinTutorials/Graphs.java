package AlvinTutorials;

import java.util.*;

public class Graphs {

    static Map<String, List<String>> graph;
    static Map<String, List<String>> graphHasPath;
    static Map<Integer, List<Integer>> graphConnectedComponentsCount;
    static Map<Integer, List<Integer>> graphLargestComponent;

    static {
        graph = new HashMap<>();
        graph.put("a", Arrays.asList("b", "c"));
        graph.put("b", Arrays.asList("d"));
        graph.put("c", Arrays.asList("e"));
        graph.put("d", Arrays.asList("f"));
        graph.put("e", Arrays.asList());
        graph.put("f", Arrays.asList());
    }

    static {
        graphHasPath = new HashMap<>();
        graphHasPath.put("f", Arrays.asList("g", "i"));
        graphHasPath.put("g", Arrays.asList("h"));
        graphHasPath.put("h", Arrays.asList());
        graphHasPath.put("i", Arrays.asList("g", "k"));
        graphHasPath.put("j", Arrays.asList("i"));
        graphHasPath.put("k", Arrays.asList());
    }

    static {
        graphConnectedComponentsCount = new HashMap<>(); //2
        graphConnectedComponentsCount.put(0, Arrays.asList(8, 1, 5));
        graphConnectedComponentsCount.put(1, Arrays.asList(0));
        graphConnectedComponentsCount.put(5, Arrays.asList(0, 8));
        graphConnectedComponentsCount.put(8, Arrays.asList(0, 5));
        graphConnectedComponentsCount.put(2, Arrays.asList(3, 4));
        graphConnectedComponentsCount.put(3, Arrays.asList(2, 3));
        graphConnectedComponentsCount.put(4, Arrays.asList(3, 2));
    }

    static {
        graphConnectedComponentsCount = new HashMap<>(); //2
        graphConnectedComponentsCount.put(0, Arrays.asList(8, 1, 5));
        graphConnectedComponentsCount.put(1, Arrays.asList(0));
        graphConnectedComponentsCount.put(5, Arrays.asList(0, 8));
        graphConnectedComponentsCount.put(8, Arrays.asList(0, 5));
        graphConnectedComponentsCount.put(2, Arrays.asList(3, 4));
        graphConnectedComponentsCount.put(3, Arrays.asList(2, 4));
        graphConnectedComponentsCount.put(4, Arrays.asList(3, 2));
    }

    public static void main(String[] args) {
        depthFirstSearch(graph, "a");
        System.out.println("--------------");
        depthFirstSearchIterative(graph, "a");
        System.out.println("--------------");
        breadthFirstSearch(graph, "a");

        System.out.println("Has Path ---------------------");

        System.out.println("Has Path depth " + hasPathDepthFirst(graphHasPath, "f", "k"));
        System.out.println("Has Path breadth " + hasPathBreadthFirst(graphHasPath, "f", "k"));

        System.out.println("______Undirected graph");
        System.out.println("Undirected Graph has path " + undirectedPath(buildGraph(), "j", "m"));

        System.out.println("------------Connected Graph------");
        System.out.println("2 == " + connectedComponentsCount(graphConnectedComponentsCount));


    }

    public static void depthFirstSearch(Map<String, List<String>> graph, String source) {
        System.out.println(source);
        for (String neighbor : graph.get(source)) {
            depthFirstSearch(graph, neighbor);
        }
    }

    public static void depthFirstSearchIterative(Map<String, List<String>> graph, String source) {
        Stack<String> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            String current = stack.pop();
            System.out.println(current);

            for (String neighbor : graph.get(current)) {
                stack.push(neighbor);
            }
        }
    }

    public static void breadthFirstSearch(Map<String, List<String>> graph, String source) {
        Queue<String> queue = new LinkedList();
        queue.add(source);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println(current);

            for (String neighbor : graph.get(current)) {
                queue.add(neighbor);
            }
        }
    }

    static boolean hasPathDepthFirst(Map<String, List<String>> graph, String source, String destination) {
        if (source.equals(destination)) return true;
        for (String neighbor : graph.get(source)) {
            if (hasPathDepthFirst(graph, neighbor, destination)) return true;
        }
        return false;
    }

    static boolean hasPathBreadthFirst(Map<String, List<String>> graph, String source, String destination) {
        Queue<String> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(destination)) return true;

            for (String neighbor : graph.get(current)) {
                queue.add(neighbor);
            }
        }
        return false;
    }

    static boolean undirectedPath(Map<String, List<String>> graph, String source, String destination) {
        return undirectedPath(graph, source, destination, new HashSet<>());
    }

    static boolean undirectedPath(Map<String, List<String>> graph, String source, String destination, Set<String> visited) {
        if (visited.contains(source)) return false;
        if (source.equals(destination)) return true;

        visited.add(source);

        for (String neighbor : graph.get(source)) {
            if (undirectedPath(graph, neighbor, destination, visited)) return true;
        }
        return false;
    }

    static Map<String, List<String>> buildGraph() {
        Map<String, List<String>> g = new HashMap<>();
        g.put("i", Arrays.asList("j", "k"));
        g.put("j", Arrays.asList("i"));
        g.put("k", Arrays.asList("i", "m", "l"));
        g.put("m", Arrays.asList("k"));
        g.put("l", Arrays.asList("k"));
        g.put("o", Arrays.asList("n"));
        g.put("n", Arrays.asList("o"));
        return g;
    }

    static int connectedComponentsCount(Map<Integer, List<Integer>> graph) {
        int count = 0;
        Set<Integer> visited = new HashSet<>();

        for (Integer node : graph.keySet()) {
            if (connectedComponentsCount(graph, node, visited)) count++;
        }

        return count;
    }


    static boolean connectedComponentsCount(Map<Integer, List<Integer>> graph, Integer source, Set<Integer> visited) {
        if (visited.contains(source)) return false;
        visited.add(source);

        for (Integer neighbor : graph.get(source)) {
            connectedComponentsCount(graph, neighbor, visited);
        }
        return true;
    }

    static int largestComponent(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        int longest = 0;

        for (Integer node : graph.keySet()) {
            int size = explore(graph, node, visited);
            longest = Math.max(longest, size);
        }
        return longest;
    }

    static int explore(Map<Integer, List<Integer>> graph, Integer source, Set<Integer> visited) {
        if (visited.contains(source)) return 0;

        visited.add(source);

        int size = 1;

        for (Integer node : graph.get(source)) {
            size += explore(graph, node, visited);
        }

        return size;
    }

    static int shortestPath(Map<String, List<String>> graph, String source, String destination) {
        Queue<NodeDistance> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new NodeDistance(source, 0));
        visited.add(source);


        while (!queue.isEmpty()) {
            NodeDistance current = queue.poll();

            if (current.node.equals(destination)) {
                return current.distance;
            }
            for (String neighbour : graph.get(current.node)) {
                if (!visited.contains(neighbour)) {
                    visited.add(current.node);
                    queue.add(new NodeDistance(neighbour, current.distance++));
                }
            }
        }
        return -1;
    }

    static String[][] grid;

    static {
        String[][] grid = {
                {"W", "L", "W", "W", "W"},
                {"W", "L", "W", "W", "W"},
                {"W", "W", "W", "L", "W"},
                {"W", "W", "L", "L", "W"},
                {"L", "W", "W", "L", "L"},
                {"L", "L", "W", "W", "W"}
        };
    }

    static int islandCount(String[][] grid) {
        Set<String> visited = new HashSet<>();

        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[c].length; c++) {
                if (exploreGrid(grid, r, c, visited)) count++;
            }
        }
        return count;
    }

    private static boolean exploreGrid(String[][] grid, int r, int c, Set<String> visited) {
        boolean rowInbounds = 0 <= r && r < grid.length;
        boolean colInbounds = 0 <= c && c < grid[r].length;
        if (!rowInbounds || !colInbounds) return false;

        if (grid[r][c].equals("W")) return false;

        String pos = r + "," + c;
        if (visited.contains(pos))
            return false;
        visited.add(pos);

        exploreGrid(grid, r - 1, c, visited);
        exploreGrid(grid, r + 1, c, visited);
        exploreGrid(grid, r, c - 1, visited);
        exploreGrid(grid, r, c + 1, visited);

        return true;
    }


}

class NodeDistance {

    String node;
    int distance;

    public NodeDistance(String node, int distance) {
        this.node = node;
        this.distance = distance;
    }

}
