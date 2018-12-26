import java.util.Arrays;

// We first do null check. Then we sort the weights array in ascending order. After that, we will use
// two pointers. One represents the low weight value and one represents the high weight value.
// We keep sum up the low weight and high weight and see if it is the optimal weight.
// If the current sum is greater than capacity. In order to make the next sum smaller, we decrement the high pointer.
// else, we increment the low pointer to get a higher sum next time.
// Big O : O(Nlog(N)) Space: O(1)

public class CloseTwoSum {
    class Container {
        double first;
        double second;
    }

    public Container findOptimalWeights(double capacity, double[] weights, int numOfContainers) {
        if (weights == null || weights.length == 0) {
            return new Container();
        }
        double min = 0.0;
        int minPos = 0, maxPos = weights.length - 1;
        int low = 0, high = weights.length - 1;
        Arrays.sort(weights);
        while (low < high) {
            double sum = weights[low] + weights[high];
            if (sum > min && sum <= capacity) {
                min = sum;
                minPos = low;
                maxPos = high;
            }
            if (sum > capacity) {
                high -= 1;
            } else {
                low += 1;
            }
        }
        Container container = new Container();
        container.first = weights[minPos];
        container.second = weights[maxPos];
        return container;
    }
}
