import java.util.*;

public class Boat {

    public static void main(String[] args) {
        int[] arr = {5,9,4,10,12,8,6,11,7};
        System.out.println(solution(9, arr));
    }

    public static int solution(int n, int[] arr) {
        int res = 0;
        List<Integer> group = toList(arr);
        while (group.size() > 0) {
            boolean isInfiniteLoop = true;
            int[] flag = new int[group.size()];
            for (int i = 0; i < group.size(); i++) {
                if (i != 0 && group.get(i) > group.get(i - 1)) {
                    isInfiniteLoop = false;
                    flag[i] = 1;
                } else {
                    flag[i] = 0;
                }
            }
            if (isInfiniteLoop) {
                return res;
            }
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < group.size(); i++) {
                if (flag[i] == 0) {
                    temp.add(group.get(i));
                }
            }
            group = temp;
            res += 1;
        }
        return res;
    }

    private static List<Integer> toList(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
