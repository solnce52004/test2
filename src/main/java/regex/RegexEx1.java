package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx1 {
    final static String STR = "ABCD45 EFG123ABCD HIJKABCD US67 8";

//    final static String PATTERN = "ABCD";
//    final static String PATTERN = "\\d";
//    final static String PATTERN = "\\d{3}";
    final static String PATTERN = "\\w{1,4}$";

    public static void main(String[] args) {
        Pattern patternCompile = Pattern.compile(PATTERN);
        Matcher matcher = patternCompile.matcher(STR);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
