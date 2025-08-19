import java.util.*;

public class TestIvan {

    public static Map<String, Integer> arrangeList(List<String> list) {

        Map<String, Integer> result = new TreeMap<>();
        Comparator<String> valueComparator =
                (k1, k2) -> {
                    int compare =
                            result.get(k2).compareTo(result.get(k1));
                    if (compare == 0)
                        return 1;
                    else
                        return compare;
                };

        for (String str : list) {
            int freq = result.getOrDefault(str, 0);
            result.put(str, freq + 1);
        }

        Map<String, Integer> sortedByValues = new TreeMap<>(valueComparator);

        sortedByValues.putAll(result);

        return sortedByValues;

    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Sun", "Moon", "Water", "Fire", "Sun", "moon", "sun", "Water",
                "Sun", "Moon", "moon", "sun", "Earth", "Soil", "Mango", "Apple", "Banana", "soil");

        System.out.println(arrangeList(list));

    }
}
