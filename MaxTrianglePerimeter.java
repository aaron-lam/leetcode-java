public class MaxTrianglePerimeter {

    public static void main(String[] args) {
        int[] sticks = {2, 3, 4, 5, 10};
        System.out.println(maxTrianglePerimeter(sticks));
    }

    public static int maxTrianglePerimeter(int[] sticks) {
        if (sticks == null || sticks.length == 0) {
            return 0;
        }
        int maxPerimeter = 0;
        for (int i = 0; i < sticks.length; i++) {
            for (int j = i + 1; j < sticks.length; j++) {
                for (int k = j + 1; k < sticks.length; k++) {
                    int perimeter = sticks[i] + sticks[j] + sticks[k];
                    int maxSide = Math.max(sticks[i], Math.max(sticks[j], sticks[k]));
                    int otherSides = perimeter - maxSide;
                    if (maxSide < otherSides && perimeter > maxPerimeter) {
                        maxPerimeter = perimeter;
                    }
                }
            }
        }
        return maxPerimeter;
    }
}
