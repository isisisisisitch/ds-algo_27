package ca.bytetube._10_graph;


import java.util.*;

public class ListGraph<V, E> extends Graph<V, E> {
    private Set<Edge<V, E>> edges = new HashSet<>();
    private Map<V, Vertex<V, E>> vertices = new HashMap<>();
    private Comparator<Edge<V, E>> edgeComparator = (o1, o2) -> weightManager.compare(o1.weight, o2.weight);

    public ListGraph(WeightManager<E> weightManager) {
        super(weightManager);
    }


    private static class Vertex<V, E> {
        V value;
        Set<Edge<V, E>> outEdges = new HashSet<>();
        Set<Edge<V, E>> inEdges = new HashSet<>();

        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Vertex<?, ?> vertex = (Vertex<?, ?>) o;
            return Objects.equals(value, vertex.value) && Objects.equals(outEdges, vertex.outEdges) && Objects.equals(inEdges, vertex.inEdges);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "value=" + value +
                    '}';
        }
    }

    private static class Edge<V, E> {
        E weight;
        Vertex<V, E> from;
        Vertex<V, E> to;

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Edge<?, ?> edge = (Edge<?, ?>) o;
            return Objects.equals(weight, edge.weight) && Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }

        public EdgeInfo<V, E> info() {
            return new EdgeInfo<>(weight, from.value, to.value);
        }

    }

    @Override
    protected int verticesSize() {
        return vertices.size();
    }

    @Override
    protected int edgeSize() {
        return edges.size();
    }

    @Override
    protected void addVertex(V v) {
        if (vertices.containsKey(v)) return;
        vertices.put(v, new Vertex<>(v));
    }

    @Override
    protected void addEdge(V fromV, V toV) {
        addEdge(fromV, toV, null);
    }

    @Override
    protected void addEdge(V fromV, V toV, E weight) {
        //1.判断 fromV，toV 是否存在
        Vertex<V, E> fromVertex = vertices.get(fromV);
        if (fromVertex == null) {
            fromVertex = new Vertex<>(fromV);
            vertices.put(fromV, fromVertex);
        }

        Vertex<V, E> toVertex = vertices.get(toV);
        if (toVertex == null) {
            toVertex = new Vertex<>(toV);
            vertices.put(toV, toVertex);
        }

        //当程序执行到这里时，fromVertex，toVertex一定存在
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        edge.weight = weight;
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);

    }


    @Override
    protected void removeVertex(V v) {
        Vertex<V, E> vertex = vertices.remove(v);
        if (vertex == null) return;
        //对于容器，如果有边遍历边修改容器元素长度的操作时，不能遍历修改，而需要使用迭代器
//        for (Edge<V, E> edge : vertex.outEdges) {
//            removeEdge(edge.from.value, edge.to.value);
//            edges.remove(edge);
//        }
//
//        for (Edge<V, E> edge : vertex.inEdges) {
//            removeEdge(edge.from.value, edge.to.value);
//
//        }
        for (Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator(); iterator.hasNext(); ) {
            Edge<V, E> edge = iterator.next();
            edge.to.inEdges.remove(edge);
            iterator.remove();
            edges.remove(edge);
        }

        for (Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator(); iterator.hasNext(); ) {
            Edge<V, E> edge = iterator.next();
            edge.from.outEdges.remove(edge);
            iterator.remove();
            edges.remove(edge);
        }

    }


    @Override
    protected void removeEdge(V fromV, V toV) {
        Vertex<V, E> fromVertex = vertices.get(fromV);
        if (fromVertex == null) return;
        Vertex<V, E> toVertex = vertices.get(toV);
        if (toVertex == null) return;

        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);

        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }

    }

    @Override
    public void bfs(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;

        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        queue.add(beginVertex);
        visitedVertices.add(beginVertex);

        while (!queue.isEmpty()) {
            Vertex<V, E> poll = queue.poll();
            System.out.print(poll.value + " ");
            for (Edge<V, E> edge : poll.outEdges) {
                if (visitedVertices.contains(edge.to)) continue;
                queue.add(edge.to);
                visitedVertices.add(edge.to);
            }
        }
    }


    @Override
    public void bfs(V begin, VertexVisitor<V> visitor) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;

        Queue<Vertex<V, E>> queue = new LinkedList<>();
        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
        queue.add(beginVertex);
        visitedVertices.add(beginVertex);

        while (!queue.isEmpty()) {
            Vertex<V, E> poll = queue.poll();
//            System.out.println(poll);
            if (visitor.visit(poll.value)) return;
            for (Edge<V, E> outEdge : poll.outEdges) {
                if (visitedVertices.contains(outEdge.to)) continue;
                queue.add(outEdge.to);
                visitedVertices.add(outEdge.to);

            }
        }

    }

    //Set<Vertex<V, E>> visitedVertices = new HashSet<>();
    @Override
    public void dfs(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        Set<Vertex<V, E>> visitedVertices = new HashSet<>();

        dfs(beginVertex, visitedVertices);

    }


    private void dfs(Vertex<V, E> beginVertex, Set<Vertex<V, E>> visitedVertices) {
        System.out.print(beginVertex.value + " ");
        visitedVertices.add(beginVertex);
        for (Edge<V, E> edge : beginVertex.outEdges) {
            if (visitedVertices.contains(edge.to)) continue;
            dfs(edge.to, visitedVertices);

        }


    }

    //1.先将起点压入stack中，pop(),再压回stack，存入Set中
    //2.如果栈顶元素的outEdge锁对应的顶点不在set里，则需要把outEdge的起点和终点，顺序的压回到stack中
    //3.再次遍历栈顶元素，，pop(),再压回stack，存入Set中
    @Override
    public void dfs(V begin, VertexVisitor<V> visitor) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;

        Stack<Vertex<V, E>> stack = new Stack<>();
        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
        stack.push(beginVertex);//1
        //System.out.print(beginVertex.value + " ");
        if (visitor.visit(beginVertex.value)) return;
        visitedVertices.add(beginVertex);

        while (!stack.isEmpty()) {
            Vertex<V, E> vertex = stack.pop();//1，3

            for (Edge<V, E> edge : vertex.outEdges) {
                if (visitedVertices.contains(edge.to)) continue;
                stack.push(edge.from);//1
                stack.push(edge.to);//3
                // System.out.print(edge.to.value + " ");
                if (visitor.visit(edge.to.value)) return;
                visitedVertices.add(edge.to);

                //作用：能够让迭代过程继续深入，去访问更深一层的顶点
                break;
            }
        }

    }

    /**
     * 1.需要准备一个map（用来存图中inDegree信息），一个queue（缓冲区），一个list（存最终排序结果）
     * 2.将graph中所有inDegree=0的顶点存入缓冲区queue中，inDegree!=0的顶点存入map中
     * 3.出队头元素，放入list中，并且更新map中各顶点的inDegree信息
     * 4.从map中继续找inDegree=0的顶点，并存入queue中
     * 5.不断重复3，4的过程，直到queue为空
     */
    @Override
    public List<V> topologicalSort() {
        //1.需要准备一个map（用来存图中inDegree信息），一个queue（缓冲区），一个list（存最终排序结果）
        Map<Vertex<V, E>, Integer> map = new HashMap<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        List<V> list = new LinkedList<>();
        // 2.将graph中所有inDegree=0的顶点存入缓冲区queue中，inDegree!=0的顶点存入map中
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            int size = vertex.inEdges.size();
            if (size == 0) queue.add(vertex);
            else map.put(vertex, size);
        });
        //5.不断重复3，4的过程，直到queue为空
        while (!queue.isEmpty()) {
            // 3.出队头元素，放入list中，并且更新map中各顶点的inDegree信息
            Vertex<V, E> vertex = queue.poll();
            list.add(vertex.value);
            for (Edge<V, E> edge : vertex.outEdges) {
                int toIn = map.get(edge.to) - 1;
                //4.从map中继续找inDegree=0的顶点，并存入queue中
                if (toIn == 0) queue.offer(edge.to);
                else map.put(edge.to, toIn);
            }
        }

        return list;
    }

    @Override
    public Set<EdgeInfo<V, E>> mst() {
        return kruscal();
    }

    private Set<EdgeInfo<V, E>> kruscal() {
        //A mst
        Set<EdgeInfo<V, E>> edgeInfos = new HashSet<>();
        MinHeap<Edge<V, E>> minHeap = new MinHeap<>(edges, edgeComparator);
        UnionFind<Vertex<V, E>> uf = new UnionFind<>();

        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            uf.makeSet(vertex);
        });

        while (!minHeap.isEmpty() && edgeInfos.size() < vertices.size() - 1) {
            Edge<V, E> edge = minHeap.remove();
            if (uf.isSame(edge.from,edge.to)) continue;
            edgeInfos.add(edge.info());
            uf.union(edge.from,edge.to);
        }

        return edgeInfos;
    }

    private Set<EdgeInfo<V, E>> prim() {
        //A mst
        Set<EdgeInfo<V, E>> edgeInfos = new HashSet<>();
        //S
        Set<Vertex<V, E>> addVertices = new HashSet<>();
        Iterator<Vertex<V, E>> iterator = vertices.values().iterator();
        Vertex<V, E> vertex = iterator.next();//A
        addVertices.add(vertex);

        MinHeap<Edge<V, E>> minHeap = new MinHeap<>(vertex.outEdges, edgeComparator);

        while (!minHeap.isEmpty() && addVertices.size() < vertices.size()) {
            Edge<V, E> edge = minHeap.remove();
            if (addVertices.contains(edge.to)) continue;
            //AB--->A
            edgeInfos.add(edge.info());
            //B--->S
            addVertices.add(edge.to);
            minHeap.addAll(edge.to.outEdges);
        }


        return edgeInfos;
    }
}
