public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {
        char[] a = String.valueOf(n).toCharArray();
        int i = a.length - 2;
        while (i >= 0 && a[i + 1] <= a[i]) {
            i -= 1;
        }
        if (i < 0) {
            return - 1;
        }
        int j = a.length - 1;
        while (j >= 0 && a[j] <= a[i]) {
            j -= 1;
        }
        swap(a, i, j);
        reverse(a, i + 1);
        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }

    public void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void reverse(char[] a, int i) {
        int start = i, end = a.length - 1;
        while (start < end) {
            swap(a, start, end);
            start += 1;
            end -= 1;
        }
    }
}
