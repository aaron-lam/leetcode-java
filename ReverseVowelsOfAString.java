public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] arr = s.toCharArray();
        int start = 0, end = arr.length - 1;
        while (start < end) {
            while (start < end && !isVowel(arr[start])) {
                start += 1;
            }
            while (start < end && !isVowel(arr[end])) {
                end -= 1;
            }
            swap(arr, start, end);
            start += 1;
            end -= 1;
        }
        return String.valueOf(arr);
    }

    private boolean isVowel(char c) {
        char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
        for (char vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }

    private void swap(char[] arr, int idx1, int idx2) {
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
