class Solution {

    class Pair {
        int city;
        int cost;
        int stops;

        Pair(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] f : flights) {
            graph[f[0]].add(new int[]{f[1], f[2]});
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(src, 0, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            int city = cur.city;
            int cost = cur.cost;
            int stops = cur.stops;

            if (stops > k) continue;

            for (int[] nei : graph[city]) {

                int nextCity = nei[0];
                int price = nei[1];

                if (cost + price < dist[nextCity]) {

                    dist[nextCity] = cost + price;

                    q.offer(
                        new Pair(
                            nextCity,
                            cost + price,
                            stops + 1
                        )
                    );
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}