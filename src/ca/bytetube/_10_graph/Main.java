package ca.bytetube._10_graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        ListGraph<String, Integer> graph = new ListGraph<>();
//        graph.addEdge("v1", "v0", 9);
//        graph.addEdge("v0", "v4", 6);
//        graph.addEdge("v3", "v4", 1);
//        graph.addEdge("v2", "v3", 5);
//        graph.addEdge("v1", "v2", 3);
//        graph.addEdge("v2", "v0", 2);
//        graph.dfs("v2", new Graph.VertexVisitor<String>() {
//            @Override
//            public boolean visit(String val) {
//                System.out.print(val + " ");
//
//                return val.equals("v4");
//            }
//        });

        //System.out.println();
        //test1();
//        test2();
//        test3();
//        test4();
        test5();
    }


    static Graph.WeightManager weightManager = new Graph.WeightManager<Double>() {
        @Override
        public int compare(Double w1, Double w2) {
            return w1.compareTo(w2);
        }

        @Override
        public Double add(Double w1, Double w2) {
            return w1 + w2;
        }

        @Override
        public Double zero() {
            return 0.0;
        }

    };

    public static void test5() {
        Graph<Object, Double> graph = directedGraph(Data.NEGATIVE_WEIGHT2);
        Map<Object, Graph.PathInfo<Object, Double>> map = graph.shortestPath(0);
        System.out.println(map);
    }

    public static void test4() {
        Graph<Object, Double> graph = unDirectedGraph(Data.MST_02);
        Set<Graph.EdgeInfo<Object, Double>> mst = graph.mst();
        System.out.println(mst);
    }


    public static void test3() {
        Graph<Object, Double> graph = directedGraph(Data.TOPO);
        List<Object> list = graph.topologicalSort();
        System.out.println(list);
    }

    public static void test2() {
        Graph<Object, Double> graph = directedGraph(Data.DFS_02);
        graph.dfs("a");
    }

    public static void test1() {
        Graph<Object, Double> graph = directedGraph(Data.BFS_04);
        graph.bfs(5);
    }

    private static Graph<Object, Double> unDirectedGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>(weightManager);
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);
                graph.addEdge(edge[1], edge[0]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
                graph.addEdge(edge[1], edge[0], weight);
            }
        }

        return graph;

    }

    private static Graph<Object, Double> directedGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>(weightManager);
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);

            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
            }
        }

        return graph;

    }
}