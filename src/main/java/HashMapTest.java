import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    static class A {
        String name;

        A(String name) {
            this.name = name;
        }
        public boolean equals(Object obj) {
            if (obj instanceof A) {
                return ((A) obj).name.equals(this.name);
            }
            return false;
        }
    }

    public static void main(String[] args) {

        Map<A, Integer> map = new HashMap<>();

        A a1 = new A("one");
        map.put(a1, 1);

        a1.name = "two";
        A a2 = new A("one");
        map.put(a2, 2);
        for (Map.Entry<A, Integer> ee : map.entrySet()) {
            System.out.println(ee.getKey().name + " :  " + ee.getValue());
        }
        System.out.println(map.get(a1));
        System.out.println(map.get(a2));

    }
}
