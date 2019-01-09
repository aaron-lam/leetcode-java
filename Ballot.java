import java.util.HashSet;
import java.util.Set;

public class Ballot {

    public static void main(String[] args) {
        int[] cards = {1, 3, 5};
        System.out.println(isBallotPossible(cards, 10));
        System.out.println(isBallotPossible(cards, 9));
    }

    public static boolean isBallotPossible( int[] cards, int target) {
        int n = cards.length;
        Set<Integer> set = new HashSet<>();
        for (int c = 0; c < n; c++) {
            for (int d = 0; d < n; d++) {
                set.add(cards[c] + cards[d]);
            }
        }
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (set.contains(target - cards[a] - cards[b])) {
                    return true;
                }
            }
        }
        return false;
    }
}
