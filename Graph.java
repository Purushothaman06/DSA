public class Graph {
    
    java.util.ArrayList<java.util.ArrayList<Integer>> adjList = new java.util.ArrayList<>();

    /**
     * @param v
     * 
     */
    Graph(int v) {
        for(int i = 0; i < v; i++) {
            adjList.add(new java.util.ArrayList<Integer>());
        }
    }

    /**
     * @param u
     * @param v
     * 
     */
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void printAdjList() {
        for(int i = 0; i < adjList.size(); i++) {
            System.out.println("Adj list of vertex " + i);
            for(int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(" " + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }
    
    /**
     * @param v
     * 
     */
    public void bfs(int v) {
        int V = adjList.size();
        boolean[] visited = new boolean[V];

        visited[v] = true;

        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        q.add(v);

        while(q.size() != 0) {
            // dequeue 

            int vertex = q.remove();
            System.out.print(vertex + " ");
            for(int i = 0; i < adjList.get(vertex).size(); i++) {
                int adjVertex = adjList.get(vertex).get(i);
                if(!visited[adjVertex]) {
                    q.add(adjVertex);
                    visited[adjVertex] = true; 
                }
            }
        }
    }

    public void dfs(int v) {
        int V = adjList.size(); // total number of vertices
        boolean[] visited = new boolean[V];
        dfs2(v,visited);        
    }

    private void dfs2(int v,boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for(int i = 0; i < adjList.get(v).size(); i++) {
            int av = adjList.get(v).get(i);
            if(!visited[av]) 
                dfs2(av,visited);
            
        }
    }
}
