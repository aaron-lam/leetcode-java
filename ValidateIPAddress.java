public class ValidateIPAddress {

    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) {
            return "Neither";
        }
        String v4Regex = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        String v6Regex = "(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})";
        if (IP.matches(v4Regex)) {
            return "IPv4";
        }
        if (IP.matches(v6Regex)) {
            return "IPv6";
        }
        return "Neither";
    }
}
