public class Ants {

    public static void main(String[] args) {
        int[] ants = {2, 6, 7};
        int stickLen = 10;
        int[] ans = getAntTime(ants, stickLen);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] getAntTime(int[] ants, int stickLen) {
        int min = 0, max = 0;
        for (int i = 0; i < ants.length; i++) {
            min = Math.max(min, Math.min(ants[i], stickLen - ants[i]));
        }
        for (int i = 0; i < ants.length; i++) {
            max = Math.max(max, Math.max(ants[i], stickLen - ants[i]));
        }
        return new int[] {min, max};
    }
}
