import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0) {
            return 0;
        }
        Arrays.sort(people);
        int low = 0, high = people.length - 1;
        while (low <= high) {
            if (people[low] + people[high] <= limit) {
                low += 1;
            }
            high -= 1;
        }
        return people.length - 1 - high;
    }
}
