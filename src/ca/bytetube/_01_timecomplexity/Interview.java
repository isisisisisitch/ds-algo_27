package ca.bytetube._01_timecomplexity;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Interview {

    static int[] parent, rank;
    static int N, M, D;
    static List<edge> recordEdge = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/ca/bytetube/_01_timecomplexity/testcase/s4/s4.sample.02.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            edge e = new edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
            recordEdge.add(e);
        }

        Collections.sort(recordEdge);
        int num = 0;//记录加入的边的数量
        int days = 0;
        edge maxEdge = recordEdge.get(0);
        makeSet();

        for (int i = 0; i < M; i++) {
            if (num >= N - 1) break;
            edge cur = recordEdge.get(i);
            if (find(cur.from) != find(cur.to)) {
                union(cur.from, cur.to);
                num++;
                if (cur.index > N - 1) days++;
                maxEdge = cur;
            }
        }

        if (D == 0) {
            System.out.println(days);
            return;
        }
        makeSet();
        if (maxEdge.index > N - 1) {
            for (int i = 0; i < M; i++) {
                edge cur = recordEdge.get(i);
                if (find(cur.from) != find(cur.to)) {

                    if (cur.weight < maxEdge.weight || cur.weight == maxEdge.weight && cur.index <= N - 1)
                        union(cur.from, cur.to);

                    else if (cur.weight <= D && cur.index <= N - 1) {
                        days--;
                        break;
                    }
                }
            }
        }

        System.out.println(days);


    }

    private static void makeSet() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (rank[a] > rank[b]) {
                rank[a]++;
                parent[b] = a;
            } else {
                rank[b]++;
                parent[a] = b;
            }
        }
    }

    private static int find(int n) {
        if (n != parent[n]) parent[n] = find(parent[n]);
        return parent[n];
    }



    public static class edge implements Comparable<edge> {
        int from;
        int to;
        int weight;
        int index;

        public edge(int from, int to, int weight, int index) {
            this.from = from;
            this.to = to;
            this.weight = weight;
            this.index = index;
        }

        @Override
        public int compareTo(edge o) {
            return Long.compare(weight, o.weight);
        }
    }




}

