public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five += 1;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five -= 1;
                ten += 1;
            } else {
                if (ten >= 1 && five >= 1) {
                    ten -= 1;
                    five -= 1;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
