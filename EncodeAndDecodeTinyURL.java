import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {
    private Map<Integer, String> map = new HashMap<>();
    private String tinyUrl = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hashCode = longUrl.hashCode();
        map.put(hashCode, longUrl);
        return tinyUrl + hashCode;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int hashCode = Integer.parseInt(shortUrl.replace(tinyUrl, ""));
        return map.get(hashCode);
    }
}
