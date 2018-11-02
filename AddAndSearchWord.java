class AddAndSearchWord {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWordExist;
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWordExist = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return backtrack(word.toCharArray(), 0, root);
    }

    private boolean backtrack(char[] arr, int len, TrieNode cur) {
        if (len == arr.length) {
            return cur.isWordExist;
        }
        if (arr[len] != '.') {
            return cur.children[arr[len] - 'a'] != null &&
                    backtrack(arr, len + 1, cur.children[arr[len] - 'a']);
        } else {
            for (int i = 0; i < cur.children.length; i++) {
                if (cur.children[i] != null) {
                    if (backtrack(arr, len + 1, cur.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
