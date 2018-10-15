public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int start = 0, end = heights.length - 1, maxArea = 0;
        while (start < end) {
            int len = end - start;
            int width = Math.min(heights[start], heights[end]);
            int area = len * width;
            maxArea = Math.max(maxArea, area);
            if (heights[start] > heights[end]) {
                end = end - 1;
            } else {
                start = start + 1;
            }
        }
        return maxArea;
    }
}
