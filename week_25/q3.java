package week_25;

import java.util.HashSet;

public class q3 {

    public static String findFirstDuplicateEmail(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for (String email : emails) {
            if (set.contains(email)) {
                return email;
            }
            set.add(email);
        }
        return null;
    }

    public static void main(String[] args) {

        String[] emails = {
            "alice@email.com",
            "bob@email.com",
            "alice@email.com",
            "charlie@email.com"
        };

        String result = findFirstDuplicateEmail(emails);

        System.out.println(result);
    }
}
