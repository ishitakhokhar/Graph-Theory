import java.util.HashMap;
import java.util.Map;

public class iExtra {
    public static void main(String[] args) {
        frequency("Hello");
        frequency("Greetingee");
        frequency("abc");
    }

    public static void frequency(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int maxfrequency = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int freq = map.get(ch);
            if (freq > maxfrequency) {
                maxfrequency = freq;
            }
        }
        if (maxfrequency == 1) {
            System.out.println("-1");
        } else {
            System.out.println(maxfrequency);
        }
    }
}
