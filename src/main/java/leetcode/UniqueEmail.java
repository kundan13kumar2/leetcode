package leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {

    public int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<>();

        for (String str : emails) {
            String temp = str.split("@")[0].replaceAll("\\.", "").split("\\+")[0]+"@" + str.split("@")[1];
            result.add(temp);
        }

        return result.size();
    }

    public static void main(String[] args) {
        UniqueEmail email = new UniqueEmail();
        System.out.println(email.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
