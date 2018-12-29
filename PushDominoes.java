public class PushDominoes {

    public String pushDominoes(String dominoes) {
        dominoes = 'L' + dominoes + 'R';
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (int j = 1; j < dominoes.length(); j++) {
            if (dominoes.charAt(j) == '.') {
                continue;
            }
            int diff = j - i - 1;
            if (i > 0) {
                res.append(dominoes.charAt(i));
            }
            if (dominoes.charAt(i) == dominoes.charAt(j)) {
                for (int k = 0; k < diff; k++) {
                    res.append(dominoes.charAt(i));
                }
            } else if (dominoes.charAt(i) == 'L' && dominoes.charAt(j) == 'R') {
                for (int k = 0; k < diff; k++) {
                    res.append('.');
                }
            } else {
                for (int k = 0; k < diff / 2; k++) {
                    res.append('R');
                }
                if (diff % 2 == 1) {
                    res.append('.');
                }
                for (int k = 0; k < diff / 2; k++) {
                    res.append('L');
                }
            }
            i = j;
        }
        return res.toString();
    }
}
