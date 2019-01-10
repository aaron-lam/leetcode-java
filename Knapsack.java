public class Knapsack {

    public static void main(String[] args) {
        // items[weight][value]
        int[][] items = {{2, 3}, {1, 2}, {3, 4}, {2, 2}};
        System.out.println(knapsack(items, 5, 0));
    }

    private static int knapsack(int[][] items, int weight, int i) {
        if (i == items.length) {
            return 0;
        }
        if (weight < items[i][0]) {
            return knapsack(items, weight, i + 1);
        }
        return Math.max(knapsack(items, weight, i + 1),
                knapsack(items, weight - items[i][0], i + 1) + items[i][1]);
    }
}
