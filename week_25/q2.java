package week_25;

import java.util.HashMap;

public class q2 {
    public static void main(String[] args) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(101, 85);
        map.put(102, 92);
        map.put(103, 78);

        map.put(102, 95);

        map.remove(101);

        if (map.containsKey(103)) {
            System.out.println("Score of ID 103: " + map.get(103));
        } else {
            System.out.println("ID 103 not found");
        }

        System.out.println("\nAll Student Records:");
        for (Integer id : map.keySet()) {
            System.out.println("ID: " + id + " Score: " + map.get(id));
        }
    }
}
