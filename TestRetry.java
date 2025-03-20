import java.util.HashMap;
import java.util.Map;

public class TestRetry {
    private Map<String, Integer> map;

    public TestRetry() {
        map = new HashMap<>();
        map.put("foo", 1);
        map.put("bar", 3);
    }

    public int getValue(String input, int numRetries) throws Exception {
        try {
            System.out.println(input);
            return map.get(input);
        } catch (Exception e) {
            if (numRetries > 3) {
                throw e;
            }
            return getValue(input, numRetries + 1);
        }
    }

    public static void main(String[] args) {
        TestRetry mc = new TestRetry();
        try {
            System.out.println(mc.getValue("foo", 0));
        } catch (Exception e) {
        }
        try {
            System.out.println(mc.getValue("bar", 2));
        } catch (Exception e) {
        }
        try {
            System.out.println(mc.getValue("baz", 0));
        } catch (Exception e) {
        }
        try {
            System.out.println(mc.getValue("fubar", 1));
        } catch (Exception e) {
        }
    }
}